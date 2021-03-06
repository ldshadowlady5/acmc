package com.ldshadowlady.acmc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.MathHelper;

public class BlockRotate90 extends HorizontalBlock {
    public static final IntegerProperty ROTATION;

    public BlockRotate90(Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateContainer.getBaseState()).with(ROTATION, 0)));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return (BlockState)((BlockState)this.getDefaultState().with(ROTATION, MathHelper.floor((double)((180.0F + p_196258_1_.getPlacementYaw()) * 16.0F / 360.0F) + 0.5D) & 15));
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return (BlockState)p_185499_1_.with(ROTATION, p_185499_2_.rotate((Integer)p_185499_1_.get(ROTATION), 16));
    }

    public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return (BlockState)p_185471_1_.with(ROTATION, p_185471_2_.mirrorRotation((Integer)p_185471_1_.get(ROTATION), 16));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(new IProperty[]{ROTATION});
    }

    static {
        ROTATION = BlockStateProperties.ROTATION_0_15;
    }


}
