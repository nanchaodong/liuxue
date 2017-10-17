package com.wolf.liuxue.fragment;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.wolf.liuxue.R;
import com.wolf.liuxue.base.TopNoFragment;
import com.wolf.liuxue.bean.Folder;
import com.wolf.liuxue.bean.Image;
import com.wolf.liuxue.databinding.FImageSelectBinding;
import com.wolf.liuxue.presenter.RecyclerManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nanchaodong on 2017/5/17.
 */

public class ImageSelectFragment extends TopNoFragment<FImageSelectBinding> {
    private static ImageSelectFragment ins;
    private static final int LOADER_ALL = 0;
    private static final int LOADER_CATEGORY = 1;
    private boolean hasFolderGened = false;
    private List<Folder> folderList = new ArrayList<>();
    private List<Image> imageList = new ArrayList<>();
    private RecyclerManager manager;


    @Override
    public int setLayout() {
        return R.layout.f_image_select;
    }

    @SuppressLint("ValidFragment")
    private ImageSelectFragment() {
    }

    public static ImageSelectFragment getIns() {
        if (ins == null) {
            synchronized (ImageSelectFragment.class) {
                if (ins == null) {
                    ins = new ImageSelectFragment();
                }
            }
        }
        return ins;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        manager = new RecyclerManager(getActivity(), bindView.recyclerView, 3);
        getActivity().getSupportLoaderManager().initLoader(LOADER_ALL, null, mLoaderCallBack);
    }

    private LoaderManager.LoaderCallbacks<Cursor> mLoaderCallBack = new LoaderManager.LoaderCallbacks<Cursor>() {
        private final String[] IMAGE_PROJECTION = {
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.DATE_ADDED,
                MediaStore.Images.Media._ID};

        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            if (id == LOADER_ALL) {
                CursorLoader cursorLoader =
                        new CursorLoader(getActivity(),
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_PROJECTION,
                                null, null, IMAGE_PROJECTION[2] + " DESC");
                return cursorLoader;
            } else if (id == LOADER_CATEGORY) {
                CursorLoader cursorLoader = new CursorLoader(getActivity(),
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_PROJECTION,
                        IMAGE_PROJECTION[0] + " like '%" + args.getString("path") + "%'", null, IMAGE_PROJECTION[2] + " DESC");
                return cursorLoader;
            }
            return null;
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            if (data != null) {
                int count = data.getCount();
                if (count > 0) {
                    List<Image> tempList = new ArrayList<>();
                    data.moveToFirst();
                    do {
                        String path = data.getString(data.getColumnIndexOrThrow(IMAGE_PROJECTION[0]));
                        String name = data.getString(data.getColumnIndexOrThrow(IMAGE_PROJECTION[1]));
                        long dataTime = data.getLong(data.getColumnIndexOrThrow(IMAGE_PROJECTION[2]));
                        Image image = new Image(path, name, dataTime);
                        tempList.add(image);
                        if (!hasFolderGened) {
                            File imageFile = new File(path);
                            File folderFile = imageFile.getParentFile();
                            Folder folder = new Folder();
                            folder.setName(folderFile.getName());
                            folder.setPath(folderFile.getAbsolutePath());
                            folder.setCover(image);
                            if (!folderList.contains(folder)){
                                List<Image> imageList = new ArrayList<>();
                                imageList.add(image);
                                folder.setImages(imageList);
                                folderList.add(folder);
                            }else {
                                Folder f = folderList.get(folderList.indexOf(folder));
                                f.getImages().add(image);
                            }

                        }

                    } while (data.moveToNext());
                    imageList.clear();
                    imageList.addAll(tempList);
                    manager.LoadData(imageList);
                }
            }

        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {

        }
    };
}
