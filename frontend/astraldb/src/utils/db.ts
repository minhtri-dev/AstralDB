import Dexie from 'dexie';

export interface WarpRecord {
  warpId: number;
  userId: number | null;
  itemId: number;
  gachaId: number;
  gachaType: string;
  pity: number | null;
  warpTime: string;
  hsrId: number;
}

class GachaDB extends Dexie {
  warps: Dexie.Table<WarpRecord, number>;

  constructor() {
    super('GachaDB')
    this.version(1).stores({
      warps: 'warpId, gachaType',
    });
    this.warps = this.table('warps')
  }
}

export const db = new GachaDB()