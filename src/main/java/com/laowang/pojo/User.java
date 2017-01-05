package com.laowang.pojo;

/**
 * Created by Administrator on 2017/1/5.
 */
public class User {
        private Integer id;
        private String name;
        private String tel;

        public User(){}
        public User(String name,String tel){
            this.name = name;
            this.tel = tel;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        @Override
        public String toString() {
            return "UserMapper{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", tel='" + tel + '\'' +
                    '}';
        }
    }


