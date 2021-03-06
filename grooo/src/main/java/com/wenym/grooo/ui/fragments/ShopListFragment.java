/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wenym.grooo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.wenym.grooo.R;
import com.wenym.grooo.databinding.FragmentShoplistItemBinding;
import com.wenym.grooo.model.app.Shop;
import com.wenym.grooo.ui.adapters.ShopListAdapter;
import com.wenym.grooo.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;


public class ShopListFragment extends BaseFragment<FragmentShoplistItemBinding> {

    private static final String KEY = "SHOPS";

    private List<Shop> mlist = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;

    public static ShopListFragment newInstance(ArrayList<Shop> shops) {
        ShopListFragment f = new ShopListFragment();
        Bundle b = new Bundle();
        b.putParcelableArrayList(KEY, shops);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        if (b != null) {
            mlist = b.getParcelableArrayList(KEY);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shoplist_item;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        bind.recyclerView.setHasFixedSize(true);
        bind.recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        setAdapter();
    }

    private void setAdapter() {
        bind.recyclerView.setAdapter(mAdapter);
    }
}