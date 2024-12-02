package movie.fpoly.mticket.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import movie.fpoly.mticket.R;
import movie.fpoly.mticket.models.Photo_example;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {
    private final List<Photo_example> photoList;

    public SliderAdapter(List<Photo_example> photoList) {
        this.photoList = photoList;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo, viewGroup, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder sliderViewHolder, int i) {
        Photo_example photo = photoList.get(i);
        if (photo == null) {
            return;
        }
        sliderViewHolder.imageView.setImageResource(photo.getResourceId());
    }

    @Override
    public int getItemCount() {
        if (photoList != null) {
            return photoList.size();
        }
        return 0;
    }

    public static class SliderViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.slider);
        }
    }
}
