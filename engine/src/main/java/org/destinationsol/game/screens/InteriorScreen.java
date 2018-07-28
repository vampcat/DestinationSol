/*
 * Copyright 2018 MovingBlocks
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
package org.destinationsol.game.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.destinationsol.SolApplication;
import org.destinationsol.game.interior.ShipInterior;
import org.destinationsol.ui.SolInputManager;
import org.destinationsol.ui.SolUiControl;
import org.destinationsol.ui.SolUiScreen;
import org.destinationsol.ui.UiDrawer;

import java.util.ArrayList;
import java.util.List;

public class InteriorScreen implements SolUiScreen {

    private final SolUiControl exitControl;
    private final ShipInterior shipInterior;
    private List<SolUiControl> controls;
    private TextureRegion render;

    InteriorScreen() {
        controls = new ArrayList<>();
        exitControl = new SolUiControl(null, true, Input.Keys.ESCAPE); //TODO add screen area once ui makes sense
        controls.add(exitControl);
        shipInterior = new ShipInterior();
    }

    @Override
    public List<SolUiControl> getControls() {
        return controls;
    }

    @Override
    public void updateCustom(SolApplication solApplication, SolInputManager.InputPointer[] inputPointers, boolean clickedOutside) {
        if (exitControl.isJustOff()) {
            solApplication.getInputManager().setScreen(solApplication, solApplication.getGame().getScreens().mainGameScreen);
        }
        render = shipInterior.render(); // Need to render in updateCustom, when the spritebatch in CommonDrawer is not active. Otherwise, it would get really messed up.
        final Texture texture = render.getTexture();
//        if (!texture.getTextureData().isPrepared()) {
//            texture.getTextureData().prepare();
//        }
//        System.out.println("hi");
//        final Pixmap pixmap = texture.getTextureData().consumePixmap();
//        System.out.println("hi");
//        System.out.println(pixmap.getWidth());
//        System.out.println(pixmap.getHeight());
//        final Color color = new Color(pixmap.getPixel(1, 1));
//        System.out.println("hi");
//        System.out.println(color.a);
//        System.out.println(color.r);
//        System.out.println(color.g);
//        System.out.println(color.b);
//        System.out.println("-------");
    }

    @Override
    public void drawImages(UiDrawer uiDrawer, SolApplication solApplication) {
        if (render != null){
            uiDrawer.draw(render, 0.8f, 0.8f, 0f, 0f, 0.1f, 0.1f, 0f, new Color(1,1,1,1));
        }
    }
}
