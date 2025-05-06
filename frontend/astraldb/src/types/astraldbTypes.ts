declare global {
  type Banner = {
    gacha_id: number;
    banner_name: string;
    image_url: string;
    item_id: number;
  }
}

declare global {
  type Item = {
    item_id: number;
    item_name: string;
    item_type: string;
    rank_type: number;
    item_description: string;
    item_path: string;
  }
}

declare global {
  interface Warp {
    warpId: number;
    userId: number | null;
    itemId: number;
    gachaId: number;
    gachaType: string;
    pity: number | null;
    warpTime: string;
    hsrId: number;
  }
}

export {}