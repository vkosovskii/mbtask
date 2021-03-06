package com.example.filechecker.ui.fileinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.filechecker.R
import com.example.filechecker.data.FileData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.file_info_fragment.view.*
import java.io.File

class FileInfoFragment : DialogFragment() {

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
    ): View {
        val v: View = inflater.inflate(R.layout.file_info_fragment, container, false)
        val myFileData : FileData = arguments?.getParcelable("fileData")!!

        v.fileNameText.text = myFileData.fileName
        v.fileSizeText.text = myFileData.fileSize
        v.filePathText.text = myFileData.filePath
        v.fileLastModifiedText.text = myFileData.lastModified

        Picasso.get()
            .load(File(myFileData.filePath))
            .resize(500, 500)
            .centerCrop()
            .into(v.dataImage)

        v. closeButton.setOnClickListener { dismiss() }
        return v
    }

}