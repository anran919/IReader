package com.anakin.ireader.model.entity;

import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/25 0025 18:24
 */
public class IndexEntity {


    /**
     * res : 0
     * data : {"question":[{"answer_content":"提到第一个吃螃蟹的人的故事，不得不提到第五代的三大导演，他们分别是张艺谋、陈凯歌、冯小刚，当然啦，我","answer_title":"@乔怪答小飞侠：","start_video":"","question_makettime":"2016-11-24 21:00:00","question_title":"谁是第一个吃螃蟹的人？","question_id":"1544"}],"serial":[{"number":"12","read_num":"11700","maketime":"2016-11-24 21:00:00","has_audio":false,"author":{"summary":"小说作者，编剧。新书《不正常人类症候群》现已上市。","wb_name":"@张寒寺","web_url":"http://image.wufazhuce.com/FlJ2uKL9qGrmdsyWZr_CmOwg_kjt","user_id":"4814747","user_name":"张寒寺","fans_total":"1","is_settled":"0","settled_type":"0","desc":"小说作者，编剧。新书《不正常人类症候群》现已上市。"},"serial_id":"34","start_video":"","id":"206","excerpt":"他怀念这久违的气息，初遇时的勇气与迟疑，交往时的激情与试探，互诉衷肠和余生相伴，生死作别还有\u2014\u2014从未后悔。","title":"昨日重现·第十二章：心酒"}],"essay":[{"hp_makettime":"2016-11-24 21:00:00","guide_word":"对我姥姥来说，活着是无始无终的溪流，过去既不值得记忆，也不值得自豪或羞耻。","has_audio":true,"content_id":"1600","hp_title":" 吃枣的老虎","author":[{"summary":"哈尔滨中年男作者。","wb_name":"","web_url":"http://image.wufazhuce.com/FubCiknUx1DFy7xiKj5iKSKti7Ma","user_id":"7518577","user_name":" 贾行家","fans_total":"1","is_settled":"0","settled_type":"0","desc":"哈尔滨中年男作者。"}],"start_video":""}]}
     */
    public int res;
    public DataEntity data;

    public static class DataEntity {
        /**
         * question : [{"answer_content":"提到第一个吃螃蟹的人的故事，不得不提到第五代的三大导演，他们分别是张艺谋、陈凯歌、冯小刚，当然啦，我","answer_title":"@乔怪答小飞侠：","start_video":"","question_makettime":"2016-11-24 21:00:00","question_title":"谁是第一个吃螃蟹的人？","question_id":"1544"}]
         * serial : [{"number":"12","read_num":"11700","maketime":"2016-11-24 21:00:00","has_audio":false,"author":{"summary":"小说作者，编剧。新书《不正常人类症候群》现已上市。","wb_name":"@张寒寺","web_url":"http://image.wufazhuce.com/FlJ2uKL9qGrmdsyWZr_CmOwg_kjt","user_id":"4814747","user_name":"张寒寺","fans_total":"1","is_settled":"0","settled_type":"0","desc":"小说作者，编剧。新书《不正常人类症候群》现已上市。"},"serial_id":"34","start_video":"","id":"206","excerpt":"他怀念这久违的气息，初遇时的勇气与迟疑，交往时的激情与试探，互诉衷肠和余生相伴，生死作别还有\u2014\u2014从未后悔。","title":"昨日重现·第十二章：心酒"}]
         * essay : [{"hp_makettime":"2016-11-24 21:00:00","guide_word":"对我姥姥来说，活着是无始无终的溪流，过去既不值得记忆，也不值得自豪或羞耻。","has_audio":true,"content_id":"1600","hp_title":" 吃枣的老虎","author":[{"summary":"哈尔滨中年男作者。","wb_name":"","web_url":"http://image.wufazhuce.com/FubCiknUx1DFy7xiKj5iKSKti7Ma","user_id":"7518577","user_name":" 贾行家","fans_total":"1","is_settled":"0","settled_type":"0","desc":"哈尔滨中年男作者。"}],"start_video":""}]
         */
        public List<QuestionEntity> question;
        public List<SerialEntity> serial;
        public List<EssayEntity> essay;

        public static class QuestionEntity {
            /**
             * answer_content : 提到第一个吃螃蟹的人的故事，不得不提到第五代的三大导演，他们分别是张艺谋、陈凯歌、冯小刚，当然啦，我
             * answer_title : @乔怪答小飞侠：
             * start_video :
             * question_makettime : 2016-11-24 21:00:00
             * question_title : 谁是第一个吃螃蟹的人？
             * question_id : 1544
             */
            public String answer_content;
            public String answer_title;
            public String start_video;
            public String question_makettime;
            public String question_title;
            public String question_id;
        }

        public static class SerialEntity {
            /**
             * number : 12
             * read_num : 11700
             * maketime : 2016-11-24 21:00:00
             * has_audio : false
             * author : {"summary":"小说作者，编剧。新书《不正常人类症候群》现已上市。","wb_name":"@张寒寺","web_url":"http://image.wufazhuce.com/FlJ2uKL9qGrmdsyWZr_CmOwg_kjt","user_id":"4814747","user_name":"张寒寺","fans_total":"1","is_settled":"0","settled_type":"0","desc":"小说作者，编剧。新书《不正常人类症候群》现已上市。"}
             * serial_id : 34
             * start_video :
             * id : 206
             * excerpt : 他怀念这久违的气息，初遇时的勇气与迟疑，交往时的激情与试探，互诉衷肠和余生相伴，生死作别还有——从未后悔。
             * title : 昨日重现·第十二章：心酒
             */
            public String number;
            public String read_num;
            public String maketime;
            public boolean has_audio;
            public AuthorEntity author;
            public String serial_id;
            public String start_video;
            public String id;
            public String excerpt;
            public String title;

            public static class AuthorEntity {
                /**
                 * summary : 小说作者，编剧。新书《不正常人类症候群》现已上市。
                 * wb_name : @张寒寺
                 * web_url : http://image.wufazhuce.com/FlJ2uKL9qGrmdsyWZr_CmOwg_kjt
                 * user_id : 4814747
                 * user_name : 张寒寺
                 * fans_total : 1
                 * is_settled : 0
                 * settled_type : 0
                 * desc : 小说作者，编剧。新书《不正常人类症候群》现已上市。
                 */
                public String summary;
                public String wb_name;
                public String web_url;
                public String user_id;
                public String user_name;
                public String fans_total;
                public String is_settled;
                public String settled_type;
                public String desc;
            }
        }

        public static class EssayEntity {
            /**
             * hp_makettime : 2016-11-24 21:00:00
             * guide_word : 对我姥姥来说，活着是无始无终的溪流，过去既不值得记忆，也不值得自豪或羞耻。
             * has_audio : true
             * content_id : 1600
             * hp_title :  吃枣的老虎
             * author : [{"summary":"哈尔滨中年男作者。","wb_name":"","web_url":"http://image.wufazhuce.com/FubCiknUx1DFy7xiKj5iKSKti7Ma","user_id":"7518577","user_name":" 贾行家","fans_total":"1","is_settled":"0","settled_type":"0","desc":"哈尔滨中年男作者。"}]
             * start_video :
             */
            public String hp_makettime;
            public String guide_word;
            public boolean has_audio;
            public String content_id;
            public String hp_title;
            public List<AuthorEntity> author;
            public String start_video;

            public static class AuthorEntity {
                /**
                 * summary : 哈尔滨中年男作者。
                 * wb_name :
                 * web_url : http://image.wufazhuce.com/FubCiknUx1DFy7xiKj5iKSKti7Ma
                 * user_id : 7518577
                 * user_name :  贾行家
                 * fans_total : 1
                 * is_settled : 0
                 * settled_type : 0
                 * desc : 哈尔滨中年男作者。
                 */
                public String summary;
                public String wb_name;
                public String web_url;
                public String user_id;
                public String user_name;
                public String fans_total;
                public String is_settled;
                public String settled_type;
                public String desc;
            }
        }
    }
}
