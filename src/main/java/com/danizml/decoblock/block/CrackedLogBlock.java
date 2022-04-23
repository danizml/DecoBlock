package com.danizml.decoblock.block;

import com.danizml.decoblock.util.VoxelShapeHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class CrackedLogBlock extends DecoBlockHorizontalWaterloggedBlock {
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public CrackedLogBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape[] BACKREST = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(5.5, 0, 1.5, 10.5, 8, 3.5), Direction.SOUTH));
        final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(2, 0, 1.5, 14.5, 1, 14.5), Direction.SOUTH));
        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();

        for(BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(BACKREST[direction.get2DDataValue()]);
            shapes.add(BASE[direction.get2DDataValue()]);
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return SHAPES.get(state);
    }
}