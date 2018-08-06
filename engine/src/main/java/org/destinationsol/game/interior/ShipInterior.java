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
package org.destinationsol.game.interior;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import org.destinationsol.assets.Assets;

public class ShipInterior {

    private final FrameBuffer frameBuffer;
    private final TextureRegion textureRegion;
    private final SpriteBatch spriteBatch;
    private final TextureRegion bg;
    private final TextureAtlas.AtlasRegion bg2;

    public ShipInterior() {
        frameBuffer = new FrameBuffer(Pixmap.Format.RGBA4444, 1000, 1000, false);
        textureRegion = new TextureRegion(frameBuffer.getColorBufferTexture());
        textureRegion.flip(false, true);
        bg = Assets.getAtlasRegion("core:imperialSmallInterior");
        bg2 = Assets.getAtlasRegion("engine:mainMenuBg");
        spriteBatch = new SpriteBatch();
    }

    public TextureRegion render() {
        frameBuffer.begin();
//        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_ALPHA_BITS);
        spriteBatch.begin();
//        spriteBatch.draw(bg2, 0, 0, 1000, 1000);
        spriteBatch.draw(bg, 0, 0, 1000, 1000);
        spriteBatch.end();
        frameBuffer.end();
        return textureRegion;
    }
}
