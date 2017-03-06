package com.example.mrpeng.aimeinv.Http;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class myHttp2 extends Thread {
	RequestBody body;
	private String text;
	 String URL;
	 Handler hs;
	 int what;
	 /**
	  * 
	  * @param bodys 请求参数
	  * @param URLS	接口
	  * @param h	hanlder
	  * @param whats
	  * @param ct  上下文
	  * @param fs	操作类型  1请求数据   2保存数据到服务器 3分配操作  4，
	  */
	 public final static int CONNECT_TIMEOUT =60;
	public final static int READ_TIMEOUT=100;
	public final static int WRITE_TIMEOUT=60;

	Context context;
	public myHttp2(RequestBody bodys, String URLS, Handler h, int whats, Context ct) {
		// TODO Auto-generated constructor stub
		body=bodys;
		URL=URLS;
		hs=h;
		what=whats;
		context=ct;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();





		OkHttpClient okhttp = new OkHttpClient.Builder()
				.connectTimeout(10, TimeUnit.SECONDS)
				.writeTimeout(10, TimeUnit.SECONDS)
				.readTimeout(10, TimeUnit.SECONDS)
				.build();

		Request request = new Request.Builder()
        .url(URL)
        .post(body)
        .build();
		final Response response;
		okhttp.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {
				Message msg=new Message();
				msg.what=what;
				msg.obj=text;
				H.sendMessage(msg);
				Log.e("cn.com.foton", "请求失败");


			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				try {

					if (response.isSuccessful()) {
						text = response.body().string();
						Message msg=new Message();
						msg.what=what;
						msg.obj=text;
						hs.sendMessage(msg);

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});




	}
	Handler H=new Handler(){
		public void handleMessage(android.os.Message msg) {
			Toast.makeText(context,  "请求失败，请检查你的网络",Toast.LENGTH_LONG).show();

		};
	};

}
