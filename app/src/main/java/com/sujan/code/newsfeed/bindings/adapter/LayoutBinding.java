package com.sujan.code.newsfeed.bindings.adapter;

import androidx.annotation.LayoutRes;


public interface LayoutBinding {

  /**
   * Get the layout resource ID for an view that needs to be bound.
   *
   * @return the resource ID of the layout
   */
  @LayoutRes
  int getLayoutId();
}
