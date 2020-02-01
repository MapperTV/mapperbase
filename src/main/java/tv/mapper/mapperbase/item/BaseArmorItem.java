package tv.mapper.mapperbase.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;

public class BaseArmorItem extends ArmorItem
{

    public BaseArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder)
    {
        super(materialIn, slot, builder);
    }
    
    @Override
    public IArmorMaterial getArmorMaterial() {
        return this.material;
     }

}
