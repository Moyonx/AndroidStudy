package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {
    private List<Message> messages;
    private OnItemClickListener mListener;

    public MyRecycleAdapter(List<Message> messages){
        this.messages = messages;
    }

    //创建新的ViewHolder时调用的方法，但不填充视图内容
    @NonNull
    @Override
    public MyRecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.im_list_item,viewGroup,false);
        return new MyViewHolder(view, mListener);
    }

    //将ViewHolder与数据关联
    @Override
    public void onBindViewHolder(@NonNull final MyRecycleAdapter.MyViewHolder myViewHolder, int i) {
        //设置头像
        switch (messages.get(i).getIcon()){
            case "TYPE_ROBOT":
                myViewHolder.getIv_avatar().setImageResource(R.drawable.session_robot);
                break;
            case "TYPE_GAME":
                myViewHolder.getIv_avatar().setImageResource(R.drawable.icon_micro_game_comment);
                break;
            case "TYPE_SYSTEM":
                myViewHolder.getIv_avatar().setImageResource(R.drawable.session_system_notice);
                break;
            case "TYPE_STRANGER":
                myViewHolder.getIv_avatar().setImageResource(R.drawable.session_stranger);
                break;
            case "TYPE_USER":
                myViewHolder.getIv_avatar().setImageResource(R.drawable.icon_girl);
                break;
            default:
                break;
        }
        //是否官方
        if(messages.get(i).isOfficial()){
            myViewHolder.getRobot_notice().setImageResource(R.drawable.im_icon_notice_official);
        }
        //标题
        myViewHolder.getTv_title().setText(messages.get(i).getTitle());
        //描述
        myViewHolder.getTv_description().setText(messages.get(i).getDescription());
        //时间
        myViewHolder.getTv_time().setText(messages.get(i).getTime());

    }

    //获取数据集大小
    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final CircleImageView iv_avatar;
        private final TextView tv_title;
        private final TextView tv_description;
        private final TextView tv_time;
        private final ImageView robot_notice;
        private final RelativeLayout item;

        public MyViewHolder(View view, final OnItemClickListener listener) {
            super(view);
            iv_avatar = view.findViewById(R.id.iv_avatar);
            tv_title = view.findViewById(R.id.tv_title);
            tv_description = view.findViewById(R.id.tv_description);
            tv_time = view.findViewById(R.id.tv_time);
            robot_notice = view.findViewById(R.id.robot_notice);
            item = view.findViewById(R.id.item);

            //TODO 这里可以添加点击事件
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null){
                        int position = getAdapterPosition();
                        System.out.println(position);
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

        public CircleImageView getIv_avatar() {
            return iv_avatar;
        }

        public TextView getTv_title() {
            return tv_title;
        }

        public TextView getTv_description() {
            return tv_description;
        }

        public TextView getTv_time() {
            return tv_time;
        }

        public ImageView getRobot_notice() {
            return robot_notice;
        }

        public RelativeLayout getItemView() { return item; }
    }

    //定义item点击接口
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    //定义监听事件设置方法
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }
}
