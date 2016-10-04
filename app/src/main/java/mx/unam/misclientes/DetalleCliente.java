package mx.unam.misclientes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleCliente extends AppCompatActivity{

    TextView tvNombres,tvFecha,tvTelefono,tvEmail,tvDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cliente);
      //Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();
        tvNombres=(TextView) findViewById(R.id.tvGetNombre);
        tvFecha=(TextView)findViewById(R.id.tvGetFNacimiento);
        tvTelefono=(TextView)findViewById(R.id.tvGetTelefono);
        tvEmail=(TextView)findViewById(R.id.tvGetEmail);
        tvDescripcion=(TextView)findViewById(R.id.tvGetDescripcion);

        Bundle parametros=getIntent().getExtras();
        final String nombres=tvNombres.getText().toString()+parametros.getString("nombre");
        final String fecha=tvFecha.getText().toString()+parametros.getString("fecha");
        final String telefono=tvTelefono.getText().toString()+parametros.getString("telefono");
        final String email=tvEmail.getText().toString()+parametros.getString("email");
        final String descripcion=tvDescripcion.getText().toString()+parametros.getString("descripcion");

        tvNombres.setText(nombres);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        Button botonEditar;
        botonEditar=(Button)findViewById(R.id.btnEditarDatos);
        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        //Intent intento2=new Intent(DetalleCliente.this,MainActivity.class);
               // intento2.putExtra("nombred",nombres);
  //              intento2.putExtra("fechad",fecha);
//                intento2.putExtra("telefonod",telefono);
//                intento2.putExtra("emaild",email);
//                intento2.putExtra("descripciond",descripcion);

          //startActivity(intento2);
                //finish();
                ;

            onBackPressed();
            }
        });

    }

//    @Override
//    public void startActivity(Intent intent) {
//        onRestart();
//        //super.startActivity(intent);
//    }
//
//    //    ////
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();
//    }
//    //HASTA AQUI ACTIVIDAD CORRIENDO
//
//
//
// @Override
//    protected void onRestart() {
//        super.onRestart();
//
//        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
//   }

}
