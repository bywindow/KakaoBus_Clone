package com.example.kakaobus_clone.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaobus_clone.R
import com.example.kakaobus_clone.data.models.HelpBanner
import com.example.kakaobus_clone.databinding.ListBannerCardBinding

class HelpBannerAdapter(private var bannerList: List<HelpBanner>):
    RecyclerView.Adapter<HelpBannerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_banner_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bannerImage.setImageResource(bannerList[position].image)
        holder.bannerTitle.text = bannerList[position].title
        holder.bannerComment.text = bannerList[position].comment
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val bannerLayout: CardView = itemView.findViewById(R.id.banner_view)
        val bannerImage: ImageView = itemView.findViewById(R.id.banner_imageView)
        val bannerTitle: TextView = itemView.findViewById(R.id.banner_main_text)
        val bannerComment: TextView = itemView.findViewById(R.id.banner_comment_text)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                Log.d("BannerAdapter", "Click")
                Toast.makeText(itemView.context, "${position}번째 도움말을 클릭하셨습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    class ViewHolder(
//        private var binding: ListBannerCardBinding
//    ) : RecyclerView.ViewHolder(binding.root) {
//
//        init {
//
//        }
//    }
}