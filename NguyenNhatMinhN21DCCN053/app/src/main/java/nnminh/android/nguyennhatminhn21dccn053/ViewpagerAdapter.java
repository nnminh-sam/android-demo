package nnminh.android.nguyennhatminhn21dccn053;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new ProductListFragment();
            case 2:
                return new AccountFragment();
            default:
                return new ProductGridFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
