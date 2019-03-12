package xingzy.com.httpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.xingzy.HttpUtils;
import com.xingzy.JsonCallbackListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
//        String url = "http://www.mxnzp.com/api/jokes/list/random";
        String url = "http://www.mxnzp.com/xxxxxxxx";
        HttpUtils.sendRequest(null, "GET", url, Bean.class, new JsonCallbackListener<Bean>() {
            @Override
            public void success(Bean bean) {
                Log.e("===>roy", bean.toString());
            }

            @Override
            public void failure() {
                Log.e("===>roy","访问失败");
            }
        });
    }
}
