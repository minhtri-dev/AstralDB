import Dexie from 'dexie';

class GachaDB extends Dexie {
  warps: Dexie.Table<Warp, number>;

  constructor() {
    super('GachaDB')
    this.version(1).stores({
      warps: 'warpId, gachaType',
    });
    this.warps = this.table('warps')
  }
}

export const db = new GachaDB()