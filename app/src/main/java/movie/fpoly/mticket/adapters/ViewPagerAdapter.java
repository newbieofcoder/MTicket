package movie.fpoly.mticket.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import movie.fpoly.mticket.fragments_users.CategoryFragment;
import movie.fpoly.mticket.fragments_users.HomeFragment;
import movie.fpoly.mticket.fragments_users.ProfileFragment;
import movie.fpoly.mticket.fragments_users.TicketFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new CategoryFragment();
            case 2:
                return new TicketFragment();
            case 3:
                return new ProfileFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
