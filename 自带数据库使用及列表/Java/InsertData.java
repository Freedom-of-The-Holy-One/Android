package com.example.administrator.dc;

import android.content.Context;

/**
 * 数据插入
 */

public class InsertData {
    private String[] sight_name={"中山陵祭堂","中山陵音乐台","灵谷寺","流徽榭","东吴大帝孙权纪念馆","明孝陵（金水桥）"};
    private Double[] lon={118.8533434,118.84709,118.867826,118.858667,118.839498,118.83969069};
    private Double[] lat={32.062176,32.058976,32.054984,32.0535144,32.050248,32.05307156};
    private String[] type={"人文","人文","历史","历史","自然","自然"};

    private DbOperator mDbOperator;

    public void insert(Context context){
        mDbOperator=new DbOperator(context);
        for(int i=0;i<sight_name.length;i++){
            SightInfo sightInfo=new SightInfo();
            sightInfo.setSight_name(sight_name[i]);
            sightInfo.setLon(lon[i]);
            sightInfo.setLat(lat[i]);
            sightInfo.setType(type[i]);
            mDbOperator.insert(sightInfo);
        }
    }
}
