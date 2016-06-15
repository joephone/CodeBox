// Generated code from Butter Knife. Do not modify!
package com.joephone.codebox;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ListIndex$$ViewBinder<T extends com.joephone.codebox.ListIndex> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558624, "field 'back' and method 'onClick'");
    target.back = finder.castView(view, 2131558624, "field 'back'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131558473, "field 'title'");
    target.title = finder.castView(view, 2131558473, "field 'title'");
    view = finder.findRequiredView(source, 2131558563, "field 'lvIndex'");
    target.lvIndex = finder.castView(view, 2131558563, "field 'lvIndex'");
  }

  @Override public void unbind(T target) {
    target.back = null;
    target.title = null;
    target.lvIndex = null;
  }
}
