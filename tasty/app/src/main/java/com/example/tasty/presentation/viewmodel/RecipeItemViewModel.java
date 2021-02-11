package com.example.tasty.presentation.viewmodel;

import android.view.View;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import com.example.tasty.domain.model.RecipeItem;
import com.example.tasty.domain.useCases.FavouriteAddItemUseCase;
import com.example.tasty.domain.useCases.FavouriteDeleteItemUseCase;
import com.example.tasty.domain.useCases.FavouriteUpdateItemCase;

import timber.log.Timber;

public class RecipeItemViewModel {
    public static final String ITEM_VIEW_MODEL = "ItemViewModel";
    public ObservableField<String> liveTitle;
    public ObservableField<String> liveUrl;
    public ObservableBoolean isFav;
    public final FavouriteAddItemUseCase favouriteAddItemUseCase;
    public final FavouriteDeleteItemUseCase favouriteDeleteItemUseCase;
    public final FavouriteUpdateItemCase favouriteUpdateItemCase;

    public RecipeItemViewModel(FavouriteAddItemUseCase favouriteAddItemUseCase, FavouriteDeleteItemUseCase favouriteDeleteItemUseCase, FavouriteUpdateItemCase favouriteUpdateItemCase) {
        this.favouriteAddItemUseCase = favouriteAddItemUseCase;
        this.favouriteDeleteItemUseCase = favouriteDeleteItemUseCase;
        this.favouriteUpdateItemCase = favouriteUpdateItemCase;
        liveTitle = new ObservableField<>();
        liveUrl = new ObservableField<>();
        isFav = new ObservableBoolean();
    }

    public ObservableField<String> getLiveTitle() {
        return liveTitle;
    }

    public void setLiveTitle(ObservableField<String> liveTitle) {
        this.liveTitle = liveTitle;
    }

    public ObservableField<String> getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(ObservableField<String> liveUrl) {
        this.liveUrl = liveUrl;
    }

    public ObservableBoolean getIsFav() {
        return isFav;
    }

    public void setIsFav(ObservableBoolean isFav) {
        this.isFav = isFav;
    }

    public void onClickedItem(View view, RecipeItemViewModel recipeItemViewModel, boolean checked) {
        Timber.tag(ITEM_VIEW_MODEL).d("Toggle Button clicked");
        isFav.set(checked);
        if (checked) {
            favouriteAddItemUseCase.addItem(new RecipeItem(recipeItemViewModel.liveTitle.get(), recipeItemViewModel.liveUrl.get(), true));
        } else {
            favouriteDeleteItemUseCase.deleteItem(recipeItemViewModel.liveTitle.get());
        }

        favouriteUpdateItemCase.update(new RecipeItem(recipeItemViewModel.liveTitle.get(), recipeItemViewModel.liveUrl.get(), checked));
    }

}
