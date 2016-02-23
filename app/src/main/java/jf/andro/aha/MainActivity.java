package jf.andro.aha;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
  WebView wv = null;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    wv = (WebView)findViewById(R.id.webView1);
    wv.setWebViewClient(new MyWebViewClient());
    wv.getSettings().setJavaScriptEnabled(true);
    wv.loadUrl("http://www.univ-orleans.fr/lifo/Members/"
        + "Jean-Francois.Lalande/jquerymobiletest.html");

    Button back = (Button)findViewById(R.id.back);
    back.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        wv.goBack();
      }
    });
  }

  private class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
      view.loadUrl(url);
      Toast.makeText(getApplicationContext(), 
          "A link has been clicked! ", Toast.LENGTH_SHORT).show();
      return true;
    }
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
  }
}
