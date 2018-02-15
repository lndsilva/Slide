package br.senac.sp.l13.slide;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by laercio.nsilva on 15/02/2018.
 */

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    //lista das imagens
    public int[] lst_image = {
            R.drawable.astronauta,
            R.drawable.buraco_negro,
            R.drawable.nave_espacial,
            R.drawable.satelite
    };

    //lista dos nomes
    public String[] lst_title = {
            "Astronauta",
            "Satelite",
            "Galaxia",
            "Foguete"
    };

    //lista das descrições

    public String[] lst_description = {
            "Descricão 1",
            "Descricão 2",
            "Descricão 3",
            "Descricão 4"
    };

    //lista de cores de fundo

    public int[] lst_backgroudcolor = {
            Color.rgb(55, 55, 55),
            Color.rgb(239, 88, 88),
            Color.rgb(110, 49, 89),
            Color.rgb(1, 188, 212),
    };

    public SlideAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide, container, false);
        LinearLayout layoutslide = view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        TextView descricao = (TextView) view.findViewById(R.id.txtDescricao);

        layoutslide.setBackgroundColor(lst_backgroudcolor[position]);
        imgslide.setImageResource(lst_image[position]);
        txtTitle.setText(lst_title[position]);
        descricao.setText(lst_description[position]);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
