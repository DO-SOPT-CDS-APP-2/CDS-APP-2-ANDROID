package org.sopt.cds29cm.presentation.hatDetail

import android.os.Bundle
import org.sopt.cds29cm.R
import org.sopt.cds29cm.databinding.ActivityHatDetailBinding
import org.sopt.cds29cm.util.base.BindingActivity

class HatDetailActivity : BindingActivity<ActivityHatDetailBinding>(R.layout.activity_hat_detail) {

    private var _adapter: HatDetailAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initAdapter()
    }

    private fun initAdapter() {
        _adapter = HatDetailAdapter(this.baseContext)
        binding.rvHatDetail.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _adapter = null
    }
}