// Generated code from Butter Knife. Do not modify!
package com.joephone.codebox.act.scroll.act;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MapScrollAct$$ViewBinder<T extends com.joephone.codebox.act.scroll.act.MapScrollAct> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558561, "field 'layMain'");
    target.layMain = finder.castView(view, 2131558561, "field 'layMain'");
    view = finder.findRequiredView(source, 2131558564, "field 'etSearch'");
    target.etSearch = finder.castView(view, 2131558564, "field 'etSearch'");
    view = finder.findRequiredView(source, 2131558563, "field 'search02'");
    target.search02 = finder.castView(view, 2131558563, "field 'search02'");
    view = finder.findRequiredView(source, 2131558560, "field 'myScrollView'");
    target.myScrollView = finder.castView(view, 2131558560, "field 'myScrollView'");
    view = finder.findRequiredView(source, 2131558558, "field 'ivTitle'");
    target.ivTitle = finder.castView(view, 2131558558, "field 'ivTitle'");
    view = finder.findRequiredView(source, 2131558559, "field 'search01'");
    target.search01 = finder.castView(view, 2131558559, "field 'search01'");
    view = finder.findRequiredView(source, 2131558562, "field 'ivMap'");
    target.ivMap = finder.castView(view, 2131558562, "field 'ivMap'");
  }

  @Override public void unbind(T target) {
    target.layMain = null;
    target.etSearch = null;
    target.search02 = null;
    target.myScrollView = null;
    target.ivTitle = null;
    target.search01 = null;
    target.ivMap = null;
  }
}
