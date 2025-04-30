import axios from 'axios';
import { getQueryParam } from '../utils/url'
import { db } from '../utils/db'
import { WarpRecord } from '../utils/db'

function sleep(ms: number) {
  return new Promise(resolve => setTimeout(resolve, ms))
}

export async function fetchWarpData(urlString: string) {
  const authkey = getQueryParam(urlString, 'authkey')
  const authkey_ver = getQueryParam(urlString, 'authkey_ver')
  const sign_type = getQueryParam(urlString, 'sign_type')
  const gacha_type = 11
  const size = 20

  let page = 1
  let end_id = '0'
  let lastLen = 0
  const warps: any[] = []

  try {
    const latestSaved = await db.warps.orderBy('warpId').last()
    const lastWarpId = latestSaved?.warpId ?? '0'

    do {
      const params = {
        authkey,
        authkey_ver,
        sign_type,
        gacha_type,
        page,
        size,
        end_id,
      };

      const response = await axios.get('http://localhost:8080/api/v1/warp_record/getWarpLog', { params })
      const data = response.data

      if (!Array.isArray(data)) {
        console.warn('Unexpected data format:', data);
        break;
      }

      const newWarps = data.filter((item: any) => item.warpId > lastWarpId);
      warps.push(...newWarps);
      lastLen = newWarps.length;

      if (lastLen > 0) {
        end_id = data[data.length - 1].warpId;
      }

      page++;
      await sleep(500)

    } while (lastLen === size)

    await db.warps.bulkPut(warps)

    console.log(`Stored ${warps.length} new warp records in IndexedDB.`)
    return { error: null, warps }

  } catch (error) {
    console.error('Error fetching warp data:', error)
    return { error, warps: [] }
  }
}
