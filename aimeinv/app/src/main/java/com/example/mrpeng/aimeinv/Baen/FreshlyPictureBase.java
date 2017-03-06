package com.example.mrpeng.aimeinv.Baen;

import java.util.List;

/**
 * Created by Mr.peng on 2016/12/15.
 */

public class FreshlyPictureBase {
    /**
     * info : success
     * items : [{"id":25398,"imageScale":0.675381,"index":1,"likeCount":74,"liked":false,"lookCount":1921,"name":"日本辣妹西田麻衣诱惑写真图片(图13)","picture":"c09fd12a-4519-478c-9b30-5f0bb255c579"},{"id":25397,"imageScale":0.683572,"index":2,"likeCount":71,"liked":false,"lookCount":2251,"name":"日本辣妹西田麻衣诱惑写真图片(图15)","picture":"28e5a4ea-56a5-4533-825b-097d9b1f1028"},{"id":25394,"imageScale":0.693512,"index":3,"likeCount":54,"liked":false,"lookCount":2240,"name":"性感女优吉 明步护士装高清写真(图16)","picture":"360cb758-4415-40ca-8c2f-982364509e91"},{"id":25395,"imageScale":0.701357,"index":4,"likeCount":26,"liked":false,"lookCount":2202,"name":"性感女优吉 明步护士装高清写真(图17)","picture":"a1ac54ec-32f6-41c7-afa1-7c6154659782"},{"id":25396,"imageScale":0.666667,"index":5,"likeCount":34,"liked":false,"lookCount":2219,"name":"性感女优吉 明步护士装高清写真(图21)","picture":"51b82e2a-7e92-4d03-97d7-d45de02389c0"},{"id":25392,"imageScale":0.698198,"index":6,"likeCount":30,"liked":false,"lookCount":2197,"name":"性感女优吉 明步护士装高清写真(图11)","picture":"5cc7047b-c9c2-427e-a477-be6b8c35b9b3"},{"id":25393,"imageScale":0.675381,"index":7,"likeCount":18,"liked":false,"lookCount":2186,"name":"性感女优吉 明步护士装高清写真(图23)","picture":"7bdeafeb-5422-4f1c-b2da-901b41139868"},{"id":25389,"imageScale":0.675381,"index":8,"likeCount":28,"liked":false,"lookCount":2187,"name":"性感女优吉 明步护士装高清写真(图9)","picture":"86e2eba4-decd-4b46-b06b-56e757262e85"},{"id":25390,"imageScale":1.38702,"index":9,"likeCount":25,"liked":false,"lookCount":2187,"name":"性感女优吉 明步护士装高清写真(图3)","picture":"1d649f20-afa3-4419-8ec6-1e688feda770"},{"id":25391,"imageScale":0.675381,"index":10,"likeCount":47,"liked":false,"lookCount":2206,"name":"性感女优吉 明步护士装高清写真(图2)","picture":"56678ef3-6d84-4110-b709-84a688f5bb6d"},{"id":25386,"imageScale":1.53086,"index":11,"likeCount":21,"liked":false,"lookCount":2176,"name":"性感女优吉 明步护士装高清写真(图6)","picture":"7cf08f72-46f7-4656-8f57-79ccfaefbf4f"},{"id":25387,"imageScale":0.691193,"index":12,"likeCount":54,"liked":false,"lookCount":2218,"name":"性感女优吉 明步护士装高清写真(图12)","picture":"4803ddae-1931-422f-b6a2-3cd9657b546f"},{"id":25388,"imageScale":0.817942,"index":13,"likeCount":32,"liked":false,"lookCount":2183,"name":"性感女优吉 明步护士装高清写真(图4)","picture":"b1024466-220a-4306-ab44-329691167918"},{"id":25384,"imageScale":0.695847,"index":14,"likeCount":17,"liked":false,"lookCount":2151,"name":"日本90后美少女浜田由梨性感制服写真(图13)","picture":"24509c59-af46-4b57-937e-e9bc878713c4"},{"id":25385,"imageScale":0.805195,"index":15,"likeCount":23,"liked":false,"lookCount":2158,"name":"日本90后美少女浜田由梨性感制服写真(图19)","picture":"6171b70b-6f19-492b-90a5-9799f490f31c"},{"id":25383,"imageScale":0.766378,"index":16,"likeCount":15,"liked":false,"lookCount":2143,"name":"日本90后美少女浜田由梨性感制服写真(图15)","picture":"b44899c9-58db-4224-aa50-4147cb3bb1ec"},{"id":25381,"imageScale":0.668824,"index":17,"likeCount":18,"liked":false,"lookCount":2149,"name":"美空火辣性感模特elin大胆秀乳沟(图10)","picture":"1bd4ad74-2afe-420a-a958-b1eda8ebde81"},{"id":25382,"imageScale":0.668103,"index":18,"likeCount":12,"liked":false,"lookCount":2136,"name":"美空火辣性感模特elin大胆秀乳沟(图14)","picture":"aed1ccc5-a448-4875-8d86-fa6eddf62b7a"},{"id":25378,"imageScale":0.698985,"index":19,"likeCount":6,"liked":false,"lookCount":2124,"name":"美空火辣性感模特elin大胆秀乳沟(图6)","picture":"2095b822-2cdb-498a-b409-46f229fb6e39"},{"id":25379,"imageScale":0.65126,"index":20,"likeCount":13,"liked":false,"lookCount":2128,"name":"美空火辣性感模特elin大胆秀乳沟(图1)","picture":"3f8f030e-ba67-410a-8d73-2ed79577c5be"}]
     * status : true
     * total : 20
     */

    private String info;
    private boolean status;
    private int total;
    private List<ItemsBean> items;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean extends  BaseBean {
        /**
         * id : 25398
         * imageScale : 0.675381
         * index : 1
         * likeCount : 74
         * liked : false
         * lookCount : 1921
         * name : 日本辣妹西田麻衣诱惑写真图片(图13)
         * picture : c09fd12a-4519-478c-9b30-5f0bb255c579
         */

        private int id;
        private double imageScale;
        private int index;
        private int likeCount;
        private boolean liked;
        private int lookCount;
        private String name;
        private String picture;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getImageScale() {
            return imageScale;
        }

        public void setImageScale(double imageScale) {
            this.imageScale = imageScale;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public int getLookCount() {
            return lookCount;
        }

        public void setLookCount(int lookCount) {
            this.lookCount = lookCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
