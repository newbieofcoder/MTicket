package movie.fpoly.mticket.fragments_users;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;
import movie.fpoly.mticket.R;
import movie.fpoly.mticket.adapters.PhimAdapter;
import movie.fpoly.mticket.adapters.SliderAdapter;
import movie.fpoly.mticket.models.Phim_example;
import movie.fpoly.mticket.models.Photo_example;
import movie.fpoly.mticket.services.DepthPageTransformer;

public class HomeFragment extends Fragment {
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private List<Photo_example> list;
    private RecyclerView rvPhim;
    private PhimAdapter phimAdapter;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (viewPager2.getCurrentItem() == list.size() - 1) {
                viewPager2.setCurrentItem(0);
            } else {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager2 = view.findViewById(R.id.viewpager2);
        circleIndicator3 = view.findViewById(R.id.circle3);
        rvPhim = view.findViewById(R.id.rvPhim);
        phimAdapter = new PhimAdapter(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvPhim.setLayoutManager(gridLayoutManager);
        phimAdapter.setData(getPhimList());
        rvPhim.setAdapter(phimAdapter);

        list = getPhotoList();
        SliderAdapter sliderAdapter = new SliderAdapter(list);
        viewPager2.setAdapter(sliderAdapter);
        circleIndicator3.setViewPager(viewPager2);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 5000);
            }
        });
        viewPager2.setPageTransformer(new DepthPageTransformer());

        return view;
    }

    private List<Photo_example> getPhotoList() {
        List<Photo_example> photoList = new ArrayList<>();
        photoList.add(new Photo_example(R.drawable.anh1));
        photoList.add(new Photo_example(R.drawable.anh2));
        photoList.add(new Photo_example(R.drawable.anh3));
        return photoList;
    }

    private List<Phim_example> getPhimList() {
        List<Phim_example> phimList = new ArrayList<>();
        phimList.add(new Phim_example("CƯỜI XUYÊN BIÊN GIỚI", "", "", "", "", 0, R.drawable.phim1));
        phimList.add(new Phim_example("VÕ SĨ GIÁC ĐẤU II", "", "", "", "", 0, R.drawable.phim2));
        phimList.add(new Phim_example("MẬT MÃ ĐỎ", "", "", "", "", 0, R.drawable.phim3));
        phimList.add(new Phim_example("ĐÔI BẠN HỌC YÊU", "", "", "", "", 0, R.drawable.phim4));
        return phimList;
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 5000);
    }
}