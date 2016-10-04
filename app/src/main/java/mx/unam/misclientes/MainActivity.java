package mx.unam.misclientes;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.sql.DatabaseMetaData;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static mx.unam.misclientes.MainActivity.asignarFecha;

public class MainActivity extends AppCompatActivity {

   private static TextView tvFecha;


        Button btnSiguiente;
        EditText etNombre,etTelefono,etEmail,etDescripcion;
        String Nombres,FNacimiento,Telefono,Email,Descripcion;
       // TextView tvFecha1;
  //      int flag=0;


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




       // tvFecha = (TextView) findViewById(R.id.tvFecha);

       // if (flag != 0) {
            // Nombres=savedInstanceState.getString("NombresActual");
            //   Toast.makeText(this,"el nombre es: "+Nombres,Toast.LENGTH_LONG).show();
         //   flag ++;
            //Toast.makeText(this,"onCreate actividad guardada flag "+ flag,Toast.LENGTH_LONG).show();
            //Bundle parametros=getIntent().getExtras();
            //Nombres=parametros.getString("nombred");
            //Toast.makeText(this,"Regresando"+Nombres,Toast.LENGTH_LONG).show();

        //}
        //else{


          //  flag ++;
        // Toast.makeText(this,"onCreate actividad inicial",Toast.LENGTH_LONG).show();
            //Toast.makeText(this,Nombres,Toast.LENGTH_LONG).show();
            etNombre = (EditText) findViewById(R.id.etNombres);
            //tvFecha1=(TextView) findViewById(R.id.tvFecha);
            etTelefono = (EditText) findViewById(R.id.etTelefono);
            etEmail = (EditText) findViewById(R.id.etEmail);
            etDescripcion = (EditText) findViewById(R.id.etDescripcion);
            tvFecha = (TextView) findViewById(R.id.tvFecha);
            //Boolean rpta;
       // Toast.makeText(this,"herman",Toast.LENGTH_LONG).show();
            btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
            btnSiguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(validar(view)==true){
                        Toast.makeText(getBaseContext(),"Existen campos sin llenar",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Nombres = etNombre.getText().toString();
                        FNacimiento = tvFecha.getText().toString();
                        Telefono = etTelefono.getText().toString();
                        Email = etEmail.getText().toString();
                        Descripcion = etDescripcion.getText().toString();

                        Intent primerIntent = new Intent(MainActivity.this, DetalleCliente.class);
                        primerIntent.putExtra("nombre", Nombres);
                        primerIntent.putExtra("fecha", FNacimiento);
                        primerIntent.putExtra("telefono", Telefono);
                        primerIntent.putExtra("email", Email);
                        primerIntent.putExtra("descripcion", Descripcion);
                        startActivity(primerIntent);
                        //onDestroy();
                        // onSaveInstanceState(savedInstanceState);
                        // finish();

                    }
                }
            });
            //String Nombre=getResources().getString(R.id.etNombres);


//        }

    }

// @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//
//        savedInstanceState.putString("NombresActual",Nombres);
//        super.onSaveInstanceState(savedInstanceState);
//
//        Toast.makeText(this,"Ejecutando onSaveInstanceState:" + Nombres + Integer.valueOf(savedInstanceState.size()),Toast.LENGTH_LONG).show();
//    }
//
//  @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        //Toast.makeText(this,"Ejecutando onRestoreInstanceState" ,Toast.LENGTH_LONG).show();
//       Nombres=savedInstanceState.getString("NombresActual");
//        Toast.makeText(this,"Ejecutando onRestoreInstanceState: "+Nombres,Toast.LENGTH_LONG).show();
////        etNombre.setText(Nombres);
//    }

    ////
// @Override
//protected void onStart(){
//        super.onStart();
//////        Bundle parametros=getIntent().getExtras();
//////        etNombre.setText(parametros.getString("nombred"));
//////        tvFecha1.setText(parametros.getString("fechad"));
//////        etTelefono.setText(parametros.getString("telefonod"));
//////        etEmail.setText(parametros.getString("emaild"));
//////        etDescripcion.setText(parametros.getString("descripciond"));
//
//          Toast.makeText(this,"onStart actividad1",Toast.LENGTH_SHORT).show();
//    }
////
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Nombres=NombresActual;
//        etNombre.setText(Nombres);
//
//
//        Toast.makeText(this,"onResume actividad1" + Nombres,Toast.LENGTH_SHORT).show();
//    }
////    //HASTA AQUI ACTIVIDAD CORRIENDO
////
////
////


    public boolean validar(View view){
        Boolean faltante=false;
        String Nombresv=null;
        String Telefonov=null;
        String Emailv=null;
        String Descripcionv=null;
        //String Fechav=null;

        if(TextUtils.isEmpty(etNombre.getText())){
        Nombresv="Campo Nombre es requerido";
        faltante=true;
        }
        TextInputLayout tilNombre=(TextInputLayout)findViewById(R.id.tilNombres);
        toggleTextInputLayoutError(tilNombre,Nombresv);

        if(TextUtils.isEmpty(tvFecha.getText())){
            //Fechav="Campo Fecha es requerido";
            Toast.makeText(this,"Campo Fecha es requerido",Toast.LENGTH_SHORT).show();
            faltante=true;
        }
        //TextView tv=(TextView)findViewById(R.id.tvFecha);
        //toggleTextView(tv,Fechav);



        if(TextUtils.isEmpty(etTelefono.getText())){
            Telefonov="Campo Telefono es requerido";
            faltante=true;
        }
        TextInputLayout tilTelefono=(TextInputLayout)findViewById(R.id.tilTelefono);
        toggleTextInputLayoutError(tilTelefono,Telefonov);


        if(TextUtils.isEmpty(etEmail.getText())){
            Emailv="Campo Email es requerido";
            faltante=true;
        }
        TextInputLayout tilEmail=(TextInputLayout)findViewById(R.id.tilEnail);
        toggleTextInputLayoutError(tilEmail,Emailv);

        if(TextUtils.isEmpty(etDescripcion.getText())){
            Descripcionv="Campo Descripcion es requerido";
            faltante=true;
        }
        TextInputLayout tilDescripcion=(TextInputLayout)findViewById(R.id.tilDescripcion);
        toggleTextInputLayoutError(tilDescripcion,Descripcionv);
        return faltante;
    }

    public static void toggleTextInputLayoutError(TextInputLayout til,String msg){
        til.setError(msg);
        if(msg==null){
            til.setErrorEnabled(false);
        }
        else{
            til.setErrorEnabled(true);
        }
    }

    //public static void toggleTextView(TextView tv,String msg){
      //  tv.setText(msg);
        //if(msg==null){

        //}
    //}



//  @Override
//    protected void onRestart() {
//        super.onRestart();
//        etNombre.requestFocus();
//        Toast.makeText(this,"onRestart actividad1",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//       // etNombre.setText("Nombres");
//       // super.onSaveInstanceState();
//        NombresActual=Nombres;
//        Toast.makeText(this,"onPause actividad1 " + NombresActual,Toast.LENGTH_SHORT).show();
//   }
//
//    @Override
//    protected void onStop() {
//      super.onStop();
//        //onDestroy();
//        //onCreate(Bundle savedInstanceState);
//        //onStart();
//        //onResume();
//
//
//        Toast.makeText(this,"onStop actividad1",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this,"onDestroy actividad1",Toast.LENGTH_SHORT).show();
//    }



    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();


        newFragment.show(getSupportFragmentManager(), "midataPicker");

    }

//    public void mensaje(){
  //      String Nombres=etNombre.getText().toString();
    //    Toast.makeText(this,Nombres,Toast.LENGTH_LONG).show();
    //}

    public static void asignarFecha(int dia, int mes, int año) {
        //TextView tvFecha;
        //tvFecha=(TextView)find
        tvFecha.setText(dia + "/" + mes + "/" + año);
    }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            //return new DatePickerDialog(getActivity(),2, this, year, month, day);
           // DatePickerDialog dpd=new DatePickerDialog(getActivity(),2,this,year,month,day);
            String titulo="   Asignar     Fecha Nacimiento";
            //dpd.setTitle(titulo);
            //return dpd;

            MiDatePickerDialog mdpd=new MiDatePickerDialog(getActivity(),2,this,year,month,day);

            mdpd.setMiTitulo(titulo);
            return mdpd;
        }


        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Toast.makeText(getContext(),"dia: "+day+" mes: "+month+1+" año: "+year, Toast.LENGTH_LONG).show();
            asignarFecha(day, month+1, year);
        }
    }

    public static class MiDatePickerDialog extends DatePickerDialog{

        private CharSequence titulo;
        public MiDatePickerDialog(Context context, int themeResId, OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth) {
            super(context, themeResId, listener, year, monthOfYear, dayOfMonth);
        }


        public void setMiTitulo(CharSequence title) {
            this.titulo=title;
            setTitle(titulo);

        }

        @Override
        public void onDateChanged(DatePicker view, int year, int month, int dayOfMonth) {
            super.onDateChanged(view, year, month, dayOfMonth);
            setTitle(titulo);
        }


    }



}




