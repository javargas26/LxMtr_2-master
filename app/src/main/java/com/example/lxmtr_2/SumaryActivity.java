package com.example.lxmtr_2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SumaryActivity extends AppCompatActivity {

    String url= "https://streetlightdata.000webhostapp.com/write_data.php";

    //String informacion
    String clase_de_iluminacion, tramo, direccion_l1, direccion_l2, barrio, referencia_luxometro, condicion_atmosferica, interdistancia, ancho;
    //String L1
    String orientacion_l1, fuente_l1, apoyo_l1, longitud_l1, avance_calzada_l1, distancia_l1_borde,
            altura_montaje_l1, angulo_inclinacion_l1, tension_nominal_l1, tension_medida_l1, polucion_l1;
    //String L2
    String orientacion_l2, fuente_l2, apoyo_l2, longitud_l2, avance_calzada_l2, distancia_l2_borde,
            altura_montaje_l2, angulo_inclinacion_l2, tension_nominal_l2, tension_medida_l2, polucion_l2;

    //Coordenadas
    String latitud, longitud;

    //Nueve puntos
    String nueve_uno, nueve_dos, nueve_tres, nueve_cuatro,nueve_cinco,nueve_seis,nueve_siete,nueve_ocho,nueve_nueve;

    //Diez adyacentes
    String ady_uno, ady_dos, ady_tres, ady_cuatro,ady_cinco,ady_seis,ady_siete,ady_ocho,ady_nueve, ady_diez;

    //Diez opacentes
    String op_uno, op_dos, op_tres, op_cuatro,op_cinco,op_seis,op_siete,op_ocho,op_nueve, op_diez;

    //String Sumary
    String ilum_prom, ilum_min, ilum_max, unif, cumplimiento, obs;

    //String Holders
    String RESPONSABLE_Holder, date_Holder, CLASE_DE_ILIMUNACION_VEHICULAR_Holder,
            direccion_Holder, BARRIO_Holder, LUXOMETRO_Referencia_Holder, CONDICIONES_ATMOSFERICAS_DE_LA_NOCHE_Holder,
            DIRECCION_L1_Holder, DIRECCION_L2_Holder, LUMINARIA_L1_Holder, POTENCIA_BOMBILLA_L1_Holder, FUENTE_BOMBILLA_L1_Holder,
            TIPO_DE_APOYO_L1_Holder, LONGITUD_DEL_POSTE_L1_Holder, AVANCE_DE_LA_LUMINARIA_SOBRE_LA_CALZADA_L1_Holder,
            DISTANCIA_DEL_POSTE_AL_BORDE_DE_LA_CALZADA_EN_METROS_L1_Holder, ALTURA_DEL_MONTAJE_DE_LA_LUMINARIA_EN_METROS_L1_Holder,
            ANGULO_DE_INCLINACION_DE_LA_LUMINARIA_L1_Holder, TENSION_NOMINAL_DE_LUMINARIA_L1_Holder, TENSION_MEDIDA_EN_LA_RED_L1_Holder,
            ESTADO_DE_LA_LUMINARIA_POR_POLUSION_L1_Holder, LUMINARIA_L2_Holder, POTENCIA_BOMBILLA_L2_Holder, FUENTE_BOMBILLA_L2_Holder,
            TIPO_DE_APOYO_L2_Holder, LONGITUD_DEL_POSTE_L2_Holder, AVANCE_DE_LA_LUMINARIA_SOBRE_LA_CALZADA_L2_Holder,
            DISTANCIA_DEL_POSTE_AL_BORDE_DE_LA_CALZADA_EN_METROS_L2_Holder, ALTURA_DEL_MONTAJE_DE_LA_LUMINARIA_EN_METROS_L2_Holder,
            ANGULO_DE_INCLINACION_DE_LA_LUMINARIA_L2_Holder, TENSION_NOMINAL_DE_LUMINARIA_L2_Holder, TENSION_MEDIDA_EN_LA_RED_L2__Holder,
            ESTADO_DE_LA_LUMINARIA_POR_POLUSION_L2_Holder, INTERDISTANCIA_ENTRE_LUMINARIAS_CONSECUTIVAS_Holder, ANCHO_DE_LA_CALZADA_EN_METROS_Holder,
            SEPARADOR_Holder, NUMERO_DE_SEPARADORES_Holder, DISPOSICION_DE_LAS_LUMINARIAS_Holder,
            P_1_Holder, P_2_Holder, P_3_Holder, P_4_Holder, P_5_Holder, P_6_Holder, P_7_Holder, P_8_Holder, P_9_Holder,
            ADY_1_Holder, ADY_2_Holder, ADY_3_Holder, ADY_4_Holder, ADY_5_Holder, ADY_6_Holder, ADY_7_Holder, ADY_8_Holder, ADY_9_Holder, ADY_10_Holder,
            OP_1_Holder, OP_2_Holder, OP_3_Holder, OP_4_Holder, OP_5_Holder, OP_6_Holder, OP_7_Holder, OP_8_Holder, OP_9_Holder, OP_10_Holder;

    //los_que_faltan_Holder
    String ILUMINANCIA_PROMEDIO_CALZADA_Holder, ILUMINANCIA_PROMEDIO_ANDEN_ADYACENTE_Holder, ILUMINANCIA_PROMEDIO_ANDEN_OPUESTO_Holder,
            UNIFORMIDAD_GENERAL_CALZADA_Holder, UNIFORMIDAD_GENERAL_ANDEN_ADYACENTE_Holder, UNIFORMIDAD_GENERAL_ANDEN_OPUESTO_Holder,
            VALOR_MINIMO_CALZADA_Holder, VALOR_MINIMO_ANDEN_ADYACENTE_Holder, VALOR_MINIMO_ANDEN_OPUESTO_Holder,
            VALOR_MAXIMO_CALZADA_Holder, VALOR_MAXIMO_ANDEN_ADYACENTE_Holder, VALOR_MAXIMO_ANDEN_OPUESTO_Holder,
            VALOR_MIN_MAX_CALZADA_Holder, VALOR_MIN_MAX_ANDEN_ADYACENTE_Holder, VALOR_MIN_MAX_ANDEN_OPUESTO_Holder,
            VALOR_PROMEDIO_MAX_CALZADA_Holder, VALOR_PROMEDIO_MAX_ANDEN_ADYACENTE_Holder, VALOR_PROMEDIO_MAX_ANDEN_OPUESTO_Holder,
            OBSERVACIONES_Holder, CUMPLIMIENTO_Holder, value, latitud_Holder, longitud_Holder, Estado_Holder;





    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    //TextView
    TextView tv_ilumProm, tv_ilumMin, tv_ilumMax, tv_observaciones;

    //Button
    Button btnSend;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumary);

        //valores desde la actividad anterior
        Bundle bundle=getIntent().getExtras();
        clase_de_iluminacion= (String) bundle.get("clase_de_iluminacion");
        tramo=(String) bundle.get("tramo");
        direccion_l1=(String) bundle.get("direccion_l1");
        direccion_l2=(String) bundle.get("direccion_l2");
        barrio=(String) bundle.get("barrio");
        referencia_luxometro=(String) bundle.get("referencia_luxometro");
        condicion_atmosferica=(String) bundle.get("condicion_atmosferica");

        orientacion_l1=(String) bundle.get("orientacion_l1");
        fuente_l1=(String) bundle.get("fuente_l1");
        apoyo_l1=(String) bundle.get("apoyo_l1");
        longitud_l1=(String) bundle.get("longitud_l1");
        avance_calzada_l1=(String) bundle.get("avance_calzada_l1");
        distancia_l1_borde=(String) bundle.get("distancia_l1_borde");
        altura_montaje_l1=(String) bundle.get("altura_montaje_l1");
        angulo_inclinacion_l1=(String) bundle.get("angulo_inclinacion_l1");
        tension_nominal_l1=(String) bundle.get("tension_nominal_l1");
        tension_medida_l1=(String) bundle.get("tension_medida_l1");
        polucion_l1=(String) bundle.get("polucion_l1");

        orientacion_l2=(String) bundle.get("orientacion_l2");
        fuente_l2=(String) bundle.get("fuente_l2");
        apoyo_l2=(String) bundle.get("apoyo_l2");
        longitud_l2=(String) bundle.get("longitud_l2");
        avance_calzada_l2=(String) bundle.get("avance_calzada_l2");
        distancia_l2_borde=(String) bundle.get("distancia_l2_borde");
        altura_montaje_l2=(String) bundle.get("altura_montaje_l2");
        angulo_inclinacion_l2=(String) bundle.get("angulo_inclinacion_l2");
        tension_nominal_l2=(String) bundle.get("tension_nominal_l2");
        tension_medida_l2=(String) bundle.get("tension_medida_l2");
        polucion_l2=(String) bundle.get("polucion_l2");

        interdistancia=(String) bundle.get("interdistancia");
        ancho=(String) bundle.get("ancho_calzada");

        latitud=(String) bundle.get("latitud");
        longitud=(String) bundle.get("longitud");

        nueve_uno=(String)bundle.get("nueve_uno");
        nueve_dos=(String)bundle.get("nueve_dos");
        nueve_tres=(String)bundle.get("nueve_tres");
        nueve_cuatro=(String)bundle.get("nueve_cuatro");
        nueve_cinco=(String)bundle.get("nueve_cinco");
        nueve_seis=(String)bundle.get("nueve_seis");
        nueve_siete=(String)bundle.get("nueve_siete");
        nueve_ocho=(String)bundle.get("nueve_ocho");
        nueve_nueve=(String)bundle.get("nueve_nueve");

        ady_uno=(String)bundle.get("ady_uno");
        ady_dos=(String)bundle.get("ady_dos");
        ady_tres=(String)bundle.get("ady_tres");
        ady_cuatro=(String)bundle.get("ady_cuatro");
        ady_cinco=(String)bundle.get("ady_cinco");
        ady_seis=(String)bundle.get("ady_seis");
        ady_siete=(String)bundle.get("ady_siete");
        ady_ocho=(String)bundle.get("ady_ocho");
        ady_nueve=(String)bundle.get("ady_nueve");
        ady_diez=(String)bundle.get("ady_diez");

        op_uno=(String)bundle.get("op_uno");
        op_dos=(String)bundle.get("op_dos");
        op_tres=(String)bundle.get("op_tres");
        op_cuatro=(String)bundle.get("op_cuatro");
        op_cinco=(String)bundle.get("op_cinco");
        op_seis=(String)bundle.get("op_seis");
        op_siete=(String)bundle.get("op_siete");
        op_ocho=(String)bundle.get("op_ocho");
        op_nueve=(String)bundle.get("op_nueve");
        op_diez=(String)bundle.get("op_diez");

        tv_ilumProm=findViewById(R.id.tv_ilumProm);
        tv_ilumMin=findViewById(R.id.tv_ilumMin);
        tv_ilumMax=findViewById(R.id.tv_ilumMax);
        tv_observaciones=findViewById(R.id.tv_observaciones);

        btnSend= findViewById(R.id.btnSend);

        requestQueue = Volley.newRequestQueue(SumaryActivity.this);

        progressDialog = new ProgressDialog(SumaryActivity.this);

        //Send
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Showing progress dialog at user registration time.
                progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
                progressDialog.show();

                // Calling method to get value from EditText.
                GetValueFromEditText();

                // Creating string request with post method.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing response message coming from server.
                                Toast.makeText(SumaryActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(SumaryActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("RESPONSABLE", RESPONSABLE_Holder);

                        params.put("CLASE DE ILIMUNACION VEHICULAR", CLASE_DE_ILIMUNACION_VEHICULAR_Holder);
                        params.put("direccion", direccion_Holder);
                        params.put("BARRIO", BARRIO_Holder);
                        params.put("LUXOMETRO(Referencia)", LUXOMETRO_Referencia_Holder);
                        params.put("CONDICIONES ATMOSFERICAS DE LA NOCHE", CONDICIONES_ATMOSFERICAS_DE_LA_NOCHE_Holder);
                        params.put("DIRECCION L1", DIRECCION_L1_Holder);
                        params.put("DIRECCION L2", DIRECCION_L2_Holder);
                        params.put("LUMINARIA L1", LUMINARIA_L1_Holder);
                        params.put("POTENCIA BOMBILLA L1", POTENCIA_BOMBILLA_L1_Holder);
                        params.put("FUENTE BOMBILLA L1", FUENTE_BOMBILLA_L1_Holder);
                        params.put("TIPO DE APOYO L1", TIPO_DE_APOYO_L1_Holder);
                        params.put("LONGITUD DEL POSTE L1", LONGITUD_DEL_POSTE_L1_Holder);
                        params.put("AVANCE DE LA LUMINARIA SOBRE LA CALZADA L1", AVANCE_DE_LA_LUMINARIA_SOBRE_LA_CALZADA_L1_Holder);
                        params.put("DISTANCIA DEL POSTE AL BORDE DE LA CALZADA EN METROS L1", DISTANCIA_DEL_POSTE_AL_BORDE_DE_LA_CALZADA_EN_METROS_L1_Holder);
                        params.put("ALTURA DEL MONTAJE DE LA LUMINARIA EN METROS L1", ALTURA_DEL_MONTAJE_DE_LA_LUMINARIA_EN_METROS_L1_Holder);
                        params.put("ANGULO DE INCLINACION DE LA LUMINARIA L1", ANGULO_DE_INCLINACION_DE_LA_LUMINARIA_L1_Holder);
                        params.put("TENSION NOMINAL DE LUMINARIA L1", TENSION_NOMINAL_DE_LUMINARIA_L1_Holder);
                        params.put("TENSION MEDIDA EN LA RED L1", TENSION_MEDIDA_EN_LA_RED_L1_Holder);
                        params.put("ESTADO DE LA LUMINARIA POR POLUSION L1", ESTADO_DE_LA_LUMINARIA_POR_POLUSION_L1_Holder);
                        params.put("POTENCIA BOMBILLA L2", POTENCIA_BOMBILLA_L2_Holder);
                        params.put("FUENTE BOMBILLA L2", FUENTE_BOMBILLA_L2_Holder);
                        params.put("TIPO DE APOYO L2", TIPO_DE_APOYO_L2_Holder);
                        params.put("LONGITUD DEL POSTE L2", LONGITUD_DEL_POSTE_L2_Holder);
                        params.put("AVANCE DE LA LUMINARIA SOBRE LA CALZADA L2", AVANCE_DE_LA_LUMINARIA_SOBRE_LA_CALZADA_L2_Holder);
                        params.put("DISTANCIA DEL POSTE AL BORDE DE LA CALZADA EN METROS L2", DISTANCIA_DEL_POSTE_AL_BORDE_DE_LA_CALZADA_EN_METROS_L2_Holder);
                        params.put("ALTURA DEL MONTAJE DE LA LUMINARIA EN METROS L2", ALTURA_DEL_MONTAJE_DE_LA_LUMINARIA_EN_METROS_L2_Holder);
                        params.put("ANGULO DE INCLINACION DE LA LUMINARIA L2", ANGULO_DE_INCLINACION_DE_LA_LUMINARIA_L2_Holder);
                        params.put("TENSION NOMINAL DE LUMINARIA L2", TENSION_NOMINAL_DE_LUMINARIA_L2_Holder);
                        params.put("TENSION MEDIDA EN LA RED L2", TENSION_MEDIDA_EN_LA_RED_L2__Holder);
                        params.put("ESTADO DE LA LUMINARIA POR POLUSION L2", ESTADO_DE_LA_LUMINARIA_POR_POLUSION_L2_Holder);

                        params.put("INTERDISTANCIA ENTRE LUMINARIAS CONSECUTIVAS", INTERDISTANCIA_ENTRE_LUMINARIAS_CONSECUTIVAS_Holder);
                        params.put("ANCHO DE LA CALZADA EN METROS", ANCHO_DE_LA_CALZADA_EN_METROS_Holder);
                        params.put("SEPARADOR", SEPARADOR_Holder);
                        params.put("NUMERO DE SEPARADORES", NUMERO_DE_SEPARADORES_Holder);
                        params.put("DISPOSICION DE LAS LUMINARIAS", DISPOSICION_DE_LAS_LUMINARIAS_Holder);
                        params.put("PUNTO 1", P_1_Holder);
                        params.put("PUNTO 2", P_2_Holder);
                        params.put("PUNTO 3", P_3_Holder);
                        params.put("PUNTO 4", P_4_Holder);
                        params.put("PUNTO 5", P_5_Holder);
                        params.put("PUNTO 6", P_6_Holder);
                        params.put("PUNTO 7", P_7_Holder);
                        params.put("PUNTO 8", P_8_Holder);
                        params.put("PUNTO 9", P_9_Holder);
                        params.put("ANDEN ADYACENTE 1", ADY_1_Holder);
                        params.put("ANDEN ADYACENTE 2", ADY_2_Holder);
                        params.put("ANDEN ADYACENTE 3", ADY_3_Holder);
                        params.put("ANDEN ADYACENTE 4", ADY_4_Holder);
                        params.put("ANDEN ADYACENTE 5", ADY_5_Holder);
                        params.put("ANDEN ADYACENTE 6", ADY_6_Holder);
                        params.put("ANDEN ADYACENTE 7", ADY_7_Holder);
                        params.put("ANDEN ADYACENTE 8", ADY_8_Holder);
                        params.put("ANDEN ADYACENTE 9", ADY_9_Holder);
                        params.put("ANDEN ADYACENTE 10", ADY_10_Holder);
                        params.put("ANDEN OPUESTO 1", OP_1_Holder);
                        params.put("ANDEN OPUESTO 2", OP_2_Holder);
                        params.put("ANDEN OPUESTO 3", OP_3_Holder);
                        params.put("ANDEN OPUESTO 4", OP_4_Holder);
                        params.put("ANDEN OPUESTO 5", OP_5_Holder);
                        params.put("ANDEN OPUESTO 6", OP_6_Holder);
                        params.put("ANDEN OPUESTO 7", OP_7_Holder);
                        params.put("ANDEN OPUESTO 8", OP_8_Holder);
                        params.put("ANDEN OPUESTO 9", OP_9_Holder);
                        params.put("ANDEN OPUESTO 10", OP_10_Holder);

                        params.put("ILUMINANCIA PROMEDIO CALZADA",ILUMINANCIA_PROMEDIO_CALZADA_Holder );
                        params.put("ILUMINANCIA PROMEDIO ANDEN ADYACENTE", ILUMINANCIA_PROMEDIO_ANDEN_ADYACENTE_Holder);
                        params.put("ILUMINANCIA PROMEDIO ANDEN OPUESTO", ILUMINANCIA_PROMEDIO_ANDEN_OPUESTO_Holder);
                        params.put("UNIFORMIDAD GENERAL CALZADA", UNIFORMIDAD_GENERAL_CALZADA_Holder);
                        params.put("UNIFORMIDAD GENERAL ANDEN ADYACENTE", UNIFORMIDAD_GENERAL_ANDEN_ADYACENTE_Holder);
                        params.put("UNIFORMIDAD GENERAL ANDEN OPUESTO", UNIFORMIDAD_GENERAL_ANDEN_OPUESTO_Holder);
                        params.put("VALOR MINIMO CALZADA", VALOR_MAXIMO_CALZADA_Holder);
                        params.put("VALOR MINIMO ANDEN ADYACENTE", VALOR_MAXIMO_ANDEN_ADYACENTE_Holder);
                        params.put("VALOR MINIMO ANDEN OPUESTO", VALOR_MAXIMO_ANDEN_OPUESTO_Holder);
                        params.put("VALOR MAXIMO CALZADA", VALOR_MAXIMO_CALZADA_Holder);
                        params.put("VALOR MAXIMO ANDEN ADYACENTE", VALOR_MAXIMO_ANDEN_ADYACENTE_Holder);
                        params.put("VALOR MAXIMO ANDEN OPUESTO", VALOR_MAXIMO_ANDEN_OPUESTO_Holder);
                        params.put("VALOR MIN/MAX CALZADA", VALOR_MIN_MAX_CALZADA_Holder);
                        params.put("VALOR MIN/MAX ANDEN ADYACENTE", VALOR_MINIMO_ANDEN_ADYACENTE_Holder);
                        params.put("VALOR MIN/MAX ANDEN OPUESTO", VALOR_MIN_MAX_ANDEN_OPUESTO_Holder);
                        params.put("VALOR PROMEDIO/MAX CALZADA", VALOR_PROMEDIO_MAX_CALZADA_Holder);
                        params.put("VALOR PROMEDIO/MAX ANDEN ADYACENTE", VALOR_PROMEDIO_MAX_ANDEN_ADYACENTE_Holder);
                        params.put("VALOR PROMEDIO/MAX ANDEN OPUESTO", VALOR_PROMEDIO_MAX_ANDEN_OPUESTO_Holder);
                        params.put("OBSERVACIONES", OBSERVACIONES_Holder);
                        params.put("CUMPLIMIENTO", CUMPLIMIENTO_Holder);
                        params.put("value", ILUMINANCIA_PROMEDIO_CALZADA_Holder);
                        params.put("latitud", latitud_Holder);
                        params.put("longitud", longitud_Holder);
                        params.put("Estado", Estado_Holder);


                        return params;
                    }

                };

                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(SumaryActivity.this);

                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);

            }



        });
    }
    // Creating method to get value from EditText.
    public void GetValueFromEditText(){

        RESPONSABLE_Holder = "Name";

        CLASE_DE_ILIMUNACION_VEHICULAR_Holder = clase_de_iluminacion;
        direccion_Holder = tramo;
        BARRIO_Holder = barrio;
        LUXOMETRO_Referencia_Holder = referencia_luxometro;
        CONDICIONES_ATMOSFERICAS_DE_LA_NOCHE_Holder = condicion_atmosferica;
        DIRECCION_L1_Holder = direccion_l1;
        DIRECCION_L2_Holder = direccion_l2;
        LUMINARIA_L1_Holder = orientacion_l1;
        POTENCIA_BOMBILLA_L1_Holder = "potencia l1";
        FUENTE_BOMBILLA_L1_Holder = fuente_l1;
        TIPO_DE_APOYO_L1_Holder = apoyo_l1;
        LONGITUD_DEL_POSTE_L1_Holder = longitud_l1;
        AVANCE_DE_LA_LUMINARIA_SOBRE_LA_CALZADA_L1_Holder = avance_calzada_l1;
        DISTANCIA_DEL_POSTE_AL_BORDE_DE_LA_CALZADA_EN_METROS_L1_Holder = distancia_l1_borde;
        ALTURA_DEL_MONTAJE_DE_LA_LUMINARIA_EN_METROS_L1_Holder = altura_montaje_l1;
        ANGULO_DE_INCLINACION_DE_LA_LUMINARIA_L1_Holder = angulo_inclinacion_l1;
        TENSION_NOMINAL_DE_LUMINARIA_L1_Holder = tension_nominal_l1;
        TENSION_MEDIDA_EN_LA_RED_L1_Holder = tension_medida_l1;
        ESTADO_DE_LA_LUMINARIA_POR_POLUSION_L1_Holder = polucion_l1;
        LUMINARIA_L2_Holder = orientacion_l2;
        POTENCIA_BOMBILLA_L2_Holder = "potencia l2";
        FUENTE_BOMBILLA_L2_Holder = fuente_l2;
        TIPO_DE_APOYO_L2_Holder = apoyo_l2;
        LONGITUD_DEL_POSTE_L2_Holder = longitud_l2;
        AVANCE_DE_LA_LUMINARIA_SOBRE_LA_CALZADA_L2_Holder = avance_calzada_l2;
        DISTANCIA_DEL_POSTE_AL_BORDE_DE_LA_CALZADA_EN_METROS_L2_Holder = distancia_l2_borde;
        ALTURA_DEL_MONTAJE_DE_LA_LUMINARIA_EN_METROS_L2_Holder = altura_montaje_l2;
        ANGULO_DE_INCLINACION_DE_LA_LUMINARIA_L2_Holder = angulo_inclinacion_l2;
        TENSION_NOMINAL_DE_LUMINARIA_L2_Holder = tension_nominal_l2;
        TENSION_MEDIDA_EN_LA_RED_L2__Holder = tension_medida_l2;
        ESTADO_DE_LA_LUMINARIA_POR_POLUSION_L2_Holder = polucion_l2;
        INTERDISTANCIA_ENTRE_LUMINARIAS_CONSECUTIVAS_Holder = interdistancia;
        ANCHO_DE_LA_CALZADA_EN_METROS_Holder = ancho;
        SEPARADOR_Holder = "no";
        NUMERO_DE_SEPARADORES_Holder = "N/A";
        DISPOSICION_DE_LAS_LUMINARIAS_Holder = "N/A" ;
        ;
        P_1_Holder = nueve_uno;
        P_2_Holder = nueve_dos;
        P_3_Holder = nueve_tres;
        P_4_Holder = nueve_cuatro;
        P_5_Holder = nueve_cinco;
        P_6_Holder = nueve_seis;
        P_7_Holder = nueve_siete;
        P_8_Holder = nueve_ocho;
        P_9_Holder = nueve_nueve;
        ;
        ADY_1_Holder = ady_uno;
        ADY_2_Holder = ady_dos;
        ADY_3_Holder = ady_tres;
        ADY_4_Holder = ady_cuatro;
        ADY_5_Holder = ady_cinco;
        ADY_6_Holder = ady_seis;
        ADY_7_Holder = ady_siete;
        ADY_8_Holder = ady_ocho;
        ADY_9_Holder = ady_nueve;
        ADY_10_Holder = ady_diez;
        ;
        OP_1_Holder = op_uno;
        OP_2_Holder = op_dos;
        OP_3_Holder = op_tres;
        OP_4_Holder = op_cuatro;
        OP_5_Holder = op_cinco;
        OP_6_Holder = op_seis;
        OP_7_Holder = op_siete;
        OP_8_Holder = op_ocho;
        OP_9_Holder = op_nueve;
        OP_10_Holder = op_diez;
        ;
//los_que_faltan_Holder = ;
        ILUMINANCIA_PROMEDIO_CALZADA_Holder = ilum_prom;
        ILUMINANCIA_PROMEDIO_ANDEN_ADYACENTE_Holder = "falta";
        ILUMINANCIA_PROMEDIO_ANDEN_OPUESTO_Holder = "falta";
        UNIFORMIDAD_GENERAL_CALZADA_Holder = "falta";
        UNIFORMIDAD_GENERAL_ANDEN_ADYACENTE_Holder = "falta";
        UNIFORMIDAD_GENERAL_ANDEN_OPUESTO_Holder = "falta";
        VALOR_MINIMO_CALZADA_Holder = "falta";
        VALOR_MINIMO_ANDEN_ADYACENTE_Holder = "falta";
        VALOR_MINIMO_ANDEN_OPUESTO_Holder = "falta";
        VALOR_MAXIMO_CALZADA_Holder = "falta";
        VALOR_MAXIMO_ANDEN_ADYACENTE_Holder = "falta";
        VALOR_MAXIMO_ANDEN_OPUESTO_Holder = "falta";
        VALOR_MIN_MAX_CALZADA_Holder = "falta";
        VALOR_MIN_MAX_ANDEN_ADYACENTE_Holder = "falta";
        VALOR_MIN_MAX_ANDEN_OPUESTO_Holder = "falta";
        VALOR_PROMEDIO_MAX_CALZADA_Holder = "falta";
        VALOR_PROMEDIO_MAX_ANDEN_ADYACENTE_Holder = "falta";
        VALOR_PROMEDIO_MAX_ANDEN_OPUESTO_Holder = "falta";
        OBSERVACIONES_Holder = tv_observaciones.getText().toString();
        CUMPLIMIENTO_Holder = "falta";
        ;
        value = "falta";
        latitud_Holder = latitud;
        longitud_Holder = longitud;
        Estado_Holder = "falta";



    }
}
