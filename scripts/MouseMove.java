/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripts;

import com.github.joonasvali.naturalmouse.api.MouseMotion;
import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import com.github.joonasvali.naturalmouse.support.DefaultMouseMotionNature;
import com.github.joonasvali.naturalmouse.support.DefaultNoiseProvider;
import com.github.joonasvali.naturalmouse.support.DefaultOvershootManager;
import com.github.joonasvali.naturalmouse.support.DefaultSpeedManager;
import com.github.joonasvali.naturalmouse.support.Flow;
import com.github.joonasvali.naturalmouse.support.MouseMotionNature;
import com.github.joonasvali.naturalmouse.support.SinusoidalDeviationProvider;
import com.github.joonasvali.naturalmouse.util.FactoryTemplates;
import com.github.joonasvali.naturalmouse.util.FlowTemplates;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Crimson
 */
public class MouseMove {

    public void move(int x, int y) throws InterruptedException {
        Random r = new Random();
        int deviation = r.nextInt(5) - 2;
        FactoryTemplates FT = new FactoryTemplates();
        MouseMotionFactory MMF = new MouseMotionFactory();
        MMF = createFastGamerMotionFactory();
        MouseMotion motion = MMF.build(x + deviation, y - deviation);
        motion.move();
    }

    public void moveNoDev(int x, int y) throws InterruptedException {
        FactoryTemplates FT = new FactoryTemplates();
        MouseMotionFactory MMF = new MouseMotionFactory();
        MMF = createFastGamerMotionFactory();
        MouseMotion motion = MMF.build(x, y);
        motion.move();
    }

    public MouseMotionFactory createFastGamerMotionFactory() {
        return createFastGamerMotionFactory(new DefaultMouseMotionNature());
    }

    public MouseMotionFactory createFastGamerMotionFactory(MouseMotionNature nature) {
        MouseMotionFactory factory = new MouseMotionFactory(nature);
        List<Flow> flows = new ArrayList<>(Arrays.asList(
                new Flow(FlowTemplates.variatingFlow()),
                new Flow(FlowTemplates.slowStartupFlow()),
                new Flow(FlowTemplates.slowStartup2Flow()),
                new Flow(FlowTemplates.adjustingFlow()),
                new Flow(FlowTemplates.jaggedFlow())
        ));
        DefaultSpeedManager manager = new DefaultSpeedManager(flows);
        factory.setDeviationProvider(new SinusoidalDeviationProvider(SinusoidalDeviationProvider.DEFAULT_SLOPE_DIVIDER));
        factory.setNoiseProvider(new DefaultNoiseProvider(DefaultNoiseProvider.DEFAULT_NOISINESS_DIVIDER));
        factory.getNature().setReactionTimeVariationMs(75);
        manager.setMouseMovementBaseTimeMs(200);

        DefaultOvershootManager overshootManager = (DefaultOvershootManager) factory.getOvershootManager();
        overshootManager.setOvershoots(3);

        factory.setSpeedManager(manager);
        return factory;
    }

}
