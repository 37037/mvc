package cn.ahpu.springmvc.pojo;

public class User {

        private String uname;
        private String upwd;
        private String email;
        private String phone;
        private Integer role;//角色（1表示管理员）
        /**编译器默认添加一个空的构造，这个时候可以使用这个空构造。
         * 但是只要用户有了自己的有参构造，编译器就不再提供空构造了
         * 为什么？
         * 子类的构造为什么要默认调用父类的无参构造？
         * 基本类型的包装类是干什么的？
         */
        public User() {}
        public User(String uname, String upwd, String email, String phone, Integer role) {
            this.uname = uname;
            this.upwd = upwd;
            this.email = email;
            this.phone = phone;
            this.role = role;
        }

        public String getUname() {
            return uname;
        }
        public void setUname(String uname) {
            this.uname = uname;
        }
        public String getUpwd() {
            return upwd;
        }
        public void setUpwd(String upwd) {
            this.upwd = upwd;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }
        public Integer getRole() {
            return role;
        }
        public void setRole(Integer role) {
            this.role = role;
        }



    }


