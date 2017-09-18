package test;

import android.support.annotation.IdRes;
import android.util.SparseArray;
import android.view.View;
import com.github.slick.InternalOnDestroyListener;
import com.github.slick.OnDestroyListener;
import com.github.slick.SlickDelegateView;
import java.lang.Override;

public class ExampleCustomView_Slick implements InternalOnDestroyListener {
    private static ExampleCustomView_Slick hostInstance;

    private final SparseArray<SlickDelegateView<ExampleView, ExamplePresenter>> delegates = new SparseArray<>();

    public static <T extends View & ExampleView & OnDestroyListener> void bind(T exampleCustomView, @IdRes int i, float f) {
        final int id = SlickDelegateView.getId(exampleCustomView);
        if (hostInstance == null) hostInstance = new ExampleCustomView_Slick();
        SlickDelegateView<ExampleView, ExamplePresenter> delegate = hostInstance.delegates.get(id);
        if (delegate == null) {
            final ExamplePresenter presenter = new ExamplePresenter(i, f);
            delegate = new SlickDelegateView<>(presenter, exampleCustomView.getClass(), id);
            delegate.setListener(hostInstance);
            hostInstance.delegates.put(id, delegate);
        }
        ((ExampleCustomView) exampleCustomView).presenter = delegate.getPresenter();
    }

    public static <T extends View & ExampleView & OnDestroyListener> void onAttach(T exampleCustomView) {
        hostInstance.delegates.get(SlickDelegateView.getId(exampleCustomView)).onAttach(exampleCustomView);
    }

    public static <T extends View & ExampleView & OnDestroyListener> void onDetach(T exampleCustomView) {
        if(hostInstance == null || hostInstance.delegates.get(SlickDelegateView.getId(exampleCustomView)) == null) return;
        // Already has called by its delegate.
        hostInstance.delegates.get(SlickDelegateView.getId(exampleCustomView)).onDetach(exampleCustomView);
    }

    public static <T extends View & ExampleView & OnDestroyListener> void onDestroy(T exampleCustomView) {
        hostInstance.delegates.get(SlickDelegateView.getId(exampleCustomView)).onDestroy(exampleCustomView);
    }

    @Override
    public void onDestroy(int id) {
        hostInstance.delegates.remove(id);
        if (hostInstance.delegates.size() == 0) {
            hostInstance = null;
        }
    }
}