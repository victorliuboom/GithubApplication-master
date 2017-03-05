package youga.github.app.users;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import youga.github.app.BaseActivity;
import youga.github.app.R;
import youga.github.app.bean.User;
import youga.github.app.other.BaseAdapter;

public class SearchUsersActivity extends BaseActivity implements UsersContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    UsersContract.Presenter mPresenter;
    @BindView(R.id.emptyView)
    TextView mEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_users);
        ButterKnife.bind(this);


        new UsersPresenter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(new InnerAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_view, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Logger.d(query);
                mPresenter.searchUsers(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // UserFeedback.show( "SearchOnQueryTextChanged: " + s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void setPresenter(UsersContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            mEmptyView.setVisibility(View.GONE);
            mSwipeRefreshLayout.setVisibility(View.VISIBLE);
            InnerAdapter adapter = (InnerAdapter) mRecyclerView.getAdapter();
            adapter.replaceData(null);
        }
        mSwipeRefreshLayout.setEnabled(active);
        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(active));
    }

    @Override
    public void showUsers(List<User> tasks) {
        mEmptyView.setVisibility(View.GONE);
        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
        InnerAdapter adapter = (InnerAdapter) mRecyclerView.getAdapter();
        adapter.replaceData(tasks);
    }

    @Override
    public void showLoadingUsersError(String error) {
        mEmptyView.setText(error);
        mEmptyView.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setVisibility(View.GONE);
    }

    @Override
    public void showNoUsers() {
        mEmptyView.setText(R.string.no_users);
        mEmptyView.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setVisibility(View.GONE);
    }

    @Override
    public void notifyItem(User user) {
        InnerAdapter adapter = (InnerAdapter) mRecyclerView.getAdapter();
        adapter.notifyItemChanged(adapter.getDataList().indexOf(user));
    }

    class InnerAdapter extends BaseAdapter<User> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(parent.getContext(), R.layout.item_users, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.bind(position);
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.imageView)
            ImageView mImageView;
            @BindView(R.id.tv_login)
            TextView mTvLogin;
            @BindView(R.id.tv_language)
            TextView mTvLanguage;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }

            public void bind(int position) {
                ViewGroup.LayoutParams params = itemView.getLayoutParams();
                if (params == null) {
                    params = new ViewGroup.LayoutParams(getResources().getDisplayMetrics().widthPixels, ViewGroup.LayoutParams.WRAP_CONTENT);
                } else {
                    params.width = getResources().getDisplayMetrics().widthPixels;
                }
                itemView.setLayoutParams(params);

                User user = mDataList.get(position);
                Glide.with(SearchUsersActivity.this)
                        .load(Uri.parse(user.getAvatar_url()))
                        .into(mImageView);

                mTvLogin.setText(String.format("%s:%s", getString(R.string.user_name), user.getLogin()));
                mTvLanguage.setText(String.format("%s:%s", getString(R.string.preference_language),
                        user.getReference_language() == null ? getString(R.string.loading) : user.getReference_language()));

                itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(SearchUsersActivity.this, RepositoriesActivity.class);
                    intent.putExtra(User.class.getSimpleName(), user);
                    startActivity(intent);
                });
            }
        }
    }
}
