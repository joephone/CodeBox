// Generated code from Butter Knife. Do not modify!
package com.joephone.codebox;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class IndexActivity$$ViewBinder<T extends com.joephone.codebox.IndexActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558624, "field 'back'");
    target.back = finder.castView(view, 2131558624, "field 'back'");
    view = finder.findRequiredView(source, 2131558563, "field 'lvIndex'");
    target.lvIndex = finder.castView(view, 2131558563, "field 'lvIndex'");
  }

  @Override public void unbind(T target) {
    target.back = null;
    target.lvIndex = null;
  }
}
