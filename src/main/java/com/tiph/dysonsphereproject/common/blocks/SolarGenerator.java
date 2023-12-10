package com.tiph.dysonsphereproject.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SolarGenerator extends Block{
    private static final String REGISTRY_SUFFIX = "solar_generator";
    private static final float DESTROY_TIME = 2.0f;
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16.0, 8.0, 16.0);

    @Override
    public VoxelShape getShape(
            BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    public SolarGenerator(Properties p) {
        super(p);
    }

    public static String getRegistrySuffix(){
        return REGISTRY_SUFFIX;
    }

    public static float getDestroyTime(){
        return DESTROY_TIME;
    }
}
