package youga.github.app.users;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import youga.github.app.R;
import youga.github.app.bean.Repository;
import youga.github.app.bean.User;
import youga.github.app.other.BaseAdapter;

public class RepositoriesActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.tv_login)
    TextView mTvLogin;
    @BindView(R.id.tv_language)
    TextView mTvLanguage;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.emptyView)
    TextView mEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);
        ButterKnife.bind(this);

        User user = getIntent().getParcelableExtra(User.class.getSimpleName());

        Glide.with(this)
                .load(Uri.parse(user.getAvatar_url()))
                .into(mImageView);

        mTvLogin.setText(String.format("%s:%s", getString(R.string.user_name), user.getLogin()));
        mTvLanguage.setText(user.getReference_language());
        if (user.getRepositories() == null || user.getRepositories().isEmpty()) {
            mRecyclerView.setVisibility(View.GONE);
            mEmptyView.setVisibility(View.VISIBLE);
            mEmptyView.setText("No Repositories");
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            mRecyclerView.setAdapter(new InnerAdapter(user.getRepositories()));
        }
    }

    class InnerAdapter extends BaseAdapter<Repository> {

        public InnerAdapter(@NonNull List<Repository> dataList) {
            super(dataList);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(parent.getContext(), R.layout.item_repository, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.bind(position);
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.tv_name)
            TextView mTvName;
            @BindView(R.id.tv_private)
            TextView mTvPrivate;
            @BindView(R.id.tv_language)
            TextView mTvLanguage;
            @BindView(R.id.tv_description)
            TextView mTvDescription;

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

                Repository repository = mDataList.get(position);

                mTvName.setText(String.format("%s:%s", getString(R.string.name), repository.getName()));
                mTvPrivate.setText(repository.isPrivateX() ? getString(R.string.privateX) : getString(R.string.publicX));
                mTvLanguage.setText(String.format("%s:%s", getString(R.string.language), repository.getLanguage()));
                mTvDescription.setText(String.format("%s:%s", getString(R.string.description), repository.getDescription()));

            }
        }
    }
}
