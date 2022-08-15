package com.revature.pojos;

public class Request {
        public String Request_type;
        public boolean Status;
        public Integer Refund_total;
        public Integer Request_Id;
        public Integer user_Id;

        public Request() {
        }

        public Request(String Request_type, boolean Status, Integer Refund_total, Integer Request_Id, Integer user_Id) {
            this.Request_type = Request_type;
            this.Status = Status;
            this.Refund_total = Refund_total;
            this.Request_Id = Request_Id;
            this.user_Id = user_Id;
        }

        public Request(boolean Status, Integer Refund_total, Integer Request_Id, Integer user_Id) {
            this.Status = Status;
            this.Refund_total = Refund_total;
            this.Request_Id = Request_Id;
            this.user_Id = user_Id;
        }

        public Request(String Request_type, Integer Request_Id, Integer user_Id) {
        }

        public String getRequest_type() {
            return Request_type;
        }

        public void setRequest_type(String Request_type) {
            this.Request_type = Request_type;
        }

        public boolean getStatus() {
            return Status;
        }

        public void setStatus(boolean Status) {
            this.Status = Status;
        }

        public Integer getRefund_total() {
            return Refund_total;
        }

        public void setRefund_total(Integer Refund_total) {
            this.Refund_total = Refund_total;
        }

        public Integer getRequest_Id() {
            return Request_Id;
        }

        public void setRequest_Id(Integer Request_Id) {
            this.Request_Id = Request_Id;
        }

        public Integer getuser_Id() {
            return user_Id;
        }

        public void setuser_Id(Integer user_Id) {
            this.user_Id = user_Id;
        }

}
