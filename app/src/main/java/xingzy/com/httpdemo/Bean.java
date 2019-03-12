package xingzy.com.httpdemo;

import java.util.List;

/**
 * @author roy.xing
 * @date 2019/3/12
 */
public class Bean {

    /**
     * code : 1
     * msg : 数据返回成功
     * data : [{"content":"一医生遇上医闹心情郁闷，找了个酒店点了一桌好酒好菜，喝得晕晕乎乎，发现钱不够，于是发短信给科主任，帮忙带点钱来。科主任直接开个120来，进门就给他打个吊瓶，指挥人赶紧抬车上，饭菜打了两个包说要取样化验，那老板、服务员吓得站边上啥都不敢说。上车后主任就把吊瓶拨了，说我也没钱，只能这样帮你了，打个包给值班的宵夜。这医生感动的热泪眼眶，医生都是兄弟啊\u2026\u2026","updateTime":"2018-04-25 11:23:18"},{"content":"一朋友的父亲得了老年痴呆。有次我去朋友家，他父亲开门，我：\u201c我找强子！\u201d他父亲：\u201c你找他干嘛，他在写作业！\u201d我探头往屋里看，朋友正坐在小板凳，趴在桌子上，手里握着笔，绝望地看着我。","updateTime":"2018-01-19 09:07:45"},{"content":"有人说人没有性生活就是残疾！单身狗的我表示受到了一万点伤害！不过，从此以后，我又多了一个优点：身残志坚！","updateTime":"2018-05-06 11:40:50"},{"content":"儿子进门就问老爸：\u201c爸，我是不是有两个妈？\u201d 妻子听见了立马冲出来，对着丈夫那张脸一下扇了七八个：\u201c你说，你在外面养了哪个狐狸精！\u201d丈夫一脸茫然。 儿子说：\u201c上次听见老妈在卧室里对着另一个男人喊老公，我想我既然有两个老爸，肯定也有两个老妈。","updateTime":"2018-04-27 06:23:38"},{"content":"老师，我要请假。\u201d\u201c多长时间？\u201d\u201c明天一天\u201d\u201c为什么？\u201d\u201c明天我生病。\u201d\u201c哦，好的！\u2026\u2026啥？","updateTime":"2018-07-16 07:12:49"},{"content":"一出租车司机拉一名外地乘客绕圈。绕到第6圈时,乘客指着路边的一尊雕象说:\"你们这的雕象可真多,一路上我都看见了6尊一模一样的。\"　　司机一身冷汗，忙说:\"我们这地呀，就爱在路旁立一样的雕象.\"　　乘客:\"原来如此,不过还有一点我不明白。为何每尊雕像下面都有一个一模一样的老头在卖苹果?\"","updateTime":"2018-01-03 09:24:15"},{"content":"你可以尝试半夜两点打电话给你老师，说：\u201c老师，睡了么？\u201d他说：\u201c睡了，什么事？\u201d这时你用最大的力气吼出来：\u201c老子他妈的还在写作业！\u201d然后趁他没反应过来，果断挂掉！ ","updateTime":"2017-12-14 09:11:19"},{"content":"今天和老婆搞卫生，老婆叫我收拾床底，一开始还是强烈反对的，在打扫时并没有想象中那么脏， 没想到常年不打扫的床底居然一点灰尘都没有。","updateTime":"2017-10-25 22:14:51"},{"content":"妻子抱怨丈夫说：\u201c谈恋爱那阵儿，你天天到公司门口接我去你家，如今你却赖在家里一动不动。\u201d丈夫回答：\u201c结婚前，我就将这条路领着你走熟了，现在，没有必要再领着你走了。\u201d","updateTime":"2017-12-14 09:11:19"},{"content":"班主任是个老太太，很慈祥。每次开班会，她都跟我说：明天家长会叫你妈妈来！有一次，我忍不住问：为什么不叫我爸来？结果老师说：你爸初中也是我教的，我已经不想再说他了...","updateTime":"2017-11-27 00:54:51"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * content : 一医生遇上医闹心情郁闷，找了个酒店点了一桌好酒好菜，喝得晕晕乎乎，发现钱不够，于是发短信给科主任，帮忙带点钱来。科主任直接开个120来，进门就给他打个吊瓶，指挥人赶紧抬车上，饭菜打了两个包说要取样化验，那老板、服务员吓得站边上啥都不敢说。上车后主任就把吊瓶拨了，说我也没钱，只能这样帮你了，打个包给值班的宵夜。这医生感动的热泪眼眶，医生都是兄弟啊……
         * updateTime : 2018-04-25 11:23:18
         */

        private String content;
        private String updateTime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "content='" + content + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Bean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
