package antonioejemplo.com.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Susana on 31/08/2016.
 */
public class Adaptador extends ArrayAdapter<Tipos> {

    private Context con;
    private ArrayList<Tipos> miArrayList;



    //Recibe el contexto (la actividad donde se va a mostrar y un arraylist de Tipos)
    public Adaptador(Context context, ArrayList<Tipos> arrayList) {
        super(context,0, arrayList);

        this.con=context;
        this.miArrayList=arrayList;
    }

    //Devuelve la cantidad de elementos que se van a mostrar en el arraylist
    @Override
    public int getCount() {
        //return super.getCount();
        return miArrayList.size();
    }

    //Devuelve el valor de la categoría con el número de su posición.
    @Override
    public Tipos getItem(int position) {
        //return super.getItem(position);
        return miArrayList.get(position);

    }

    //Devuelve la posición del elemento
    @Override
    public long getItemId(int position) {
        //return super.getItemId(position);

        //return getItem(position).getId; Cuando los valores se recogen de una BB, se suele devolver el id del campo de la BB.DD.
        return position;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;// PATRÓN VIEWHOLDER: Clase statica definida abajo.Se controla que existan los objetos a la hora de mostrarlos. Es para optimizar el ListView.

        //Obtenemos instancia en la posici�n actual. Es obligatorio...
        final Tipos tipos = getItem(position);

        if (convertView == null) {

            //Obteniendo una instancia del inflater. Inflamos el layout de los items para mostrarlos en el listView del Activity
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);

            //Establecemos el patrón ViewHolder
            holder=new ViewHolder();

            //Definimos los controles
            holder.titulo= (TextView) convertView.findViewById(R.id.txtTitulo);
            holder.subtitulo=(TextView) convertView.findViewById(R.id.txtSubtitulo);
            holder.icono=(ImageView) convertView.findViewById(R.id.imagen);


            //Asignamos los valores a recoger en los controles usando como modelo la clase Tipos.
            holder.titulo.setText(tipos.getTitulo());
            holder.subtitulo.setText(tipos.getSubtitulo());
            holder.icono.setImageDrawable(con.getResources().getDrawable(tipos.getImagen()));


            convertView.setTag(holder);
        }

        else{
            holder = (ViewHolder) convertView   .getTag();
        }



        return convertView;
    }

    static class ViewHolder {//PATRÓN VIEWHOLDER Establecer las views necesarias.
        TextView titulo;
        TextView subtitulo;
        ImageView icono;

    }


}
