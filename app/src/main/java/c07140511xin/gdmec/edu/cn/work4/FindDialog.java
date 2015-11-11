package c07140511xin.gdmec.edu.cn.work4;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ChWx on 2015/11/8.
 */
public class FindDialog extends Dialog {
    private Button find,cancal;
    private Context appcontext;
    public FindDialog(Context context) {
        super(context);
        appcontext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find);
        setTitle("联系人查询");
        find = (Button) findViewById(R.id.find);
        cancal = (Button) findViewById(R.id.cancal);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText value = (EditText) findViewById(R.id.value);
                ContactsTable ct = new ContactsTable(appcontext);
                User[] users = ct.findUserByKey(value.getText().toString());
                StringBuffer sb = new StringBuffer();
                for (int i=0;i<users.length;i++){
                    sb.append("姓名："+users[i].getName()+"电话："+users[i].getMobile());
                }
                Toast.makeText(appcontext,sb.toString(),Toast.LENGTH_LONG).show();

            }
        });
        cancal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
