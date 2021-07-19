package com.example.filechecker.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.DialogFragment
import com.example.filechecker.R
import com.example.filechecker.data.FileData

class FileInfoFragment : DialogFragment() {

    lateinit var tvFileName : TextView
    lateinit var tvFileSize : TextView
    lateinit var tvFilePath : TextView
    lateinit var tvFileLastModifiedDate : TextView
    lateinit var tvCloseBtn : TextView
    lateinit var ivImage : ImageView

    companion object {
        fun getNewInstance(fileData: FileData) : FileInfoFragment {
            val fileInfoFragment = FileInfoFragment()
            val args = Bundle()
            args.putParcelable("fileData", fileData)
            fileInfoFragment.arguments = args
            return fileInfoFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.file_info_fragment, container, false)
        val myFileData : FileData = arguments?.getParcelable("fileData")!!

        tvFileName = v.findViewById(R.id.file_name_text)
        tvFileSize = v.findViewById(R.id.file_size_text)
        tvFileLastModifiedDate = v.findViewById(R.id.file_last_modified_text)
        tvFilePath = v.findViewById(R.id.file_path_text)
        tvCloseBtn = v.findViewById(R.id.close_button)
        ivImage = v.findViewById(R.id.data_image)

        tvFileName.text = myFileData.fileName
        tvFileSize.text = myFileData.fileSize
        tvFilePath.text = myFileData.filePath
        tvFileLastModifiedDate.text = myFileData.lastModified

        tvCloseBtn.setOnClickListener { dismiss() }

        return v
    }

}