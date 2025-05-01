import { useState } from 'react'
import { fetchWarpData } from '../../services/astraldbApi'

const Import = () => {
  const [importing, setImporting] = useState(false)
  const [page, setPage] = useState(0)
  const [count, setCount] = useState(0)
  const [banner, setBanner] = useState(0)
  const [error, setError] = useState<string | null>(null)

  const handleImport = async () => {
    setImporting(true)
    setPage(0)
    setCount(0)
    setBanner(0)
    setError(null)
  
    const testUrl = 'https://public-operation-hkrpg-sg.hoyoverse.com/common/gacha_record/api/getGachaLog?authkey_ver=1&sign_type=2&lang=en&authkey=Ji06TN0jxGmj6gWwtrf7t5mdt8UiW5Ee7AHAOskCxIc8vcCezR9YuOQLEpCO316LkpDkoG5ndeyF5NBHHyBctouL%2bgIJhozL35eM2gPbFKDmAdiwoqjsNfPMBfX4%2fd9SPMxBuRcmFT1WzV%2bbGGN9VlCcOB1pXl55NkWGG5SEuZFEGi9i7G%2fuKoNfo2D6SqmUtGIm6d5wtOxrqawJbt8UQcTIsJVrxtBRziUrhD%2fLQZ3zcO8fOe77xz58XBtzH3ndhIzgheRBnSJEBFPweonLsEl%2fd0JUyCmF81t8BvMOGIG2tzdMsA%2b4Kx1%2fSStAIfPv6U1cQpO%2f5WAOmtt00QTkMo4TK%2fW4oLS%2f57O9A%2bbrfMWZq7ATlVcz4yewYmXjR%2fWZPe4Us8P0beHT3H4nzzYTm3%2bk%2bBm%2fZ4ih3MBuf9aSFADkFqT5528PoUI9TOC5wdTJq0qagDFscFrBn8pu%2fdm70FKhZym0WFTN%2fv95CRUA2KqZRhmzO1mY8AN4HEOm7CgAkio4yOFNvNrRznYIflqj42e1Ymwl%2fAt%2fhVBZx32IAKFixdEfM26eExHg95B8to6ZbFLQeJJpGj9tDJ8zU5grqkJkuiHaMmwCrxg4z%2fXH4g7dvOratsD5vYTf%2bCOyN0CWaOOHdqcbJT12%2bh4NnpbSX3yCfvRnZviJpiP3BnAmhzo%3d&game_biz=hkrpg_global'
  
    const gachaTypes = [1, 2, 11, 12]
  
    try {
      for (const type of gachaTypes) {
        setBanner(type)
  
        const { error: fetchError } = await fetchWarpData(testUrl, type.toString(), ({ page, total }) => {
          setPage(page)
          setCount(total)
        })
  
        if (fetchError) {
          setError(`Failed on banner type ${type}`)
          break
        }
      }
    } catch (err) {
      setError('Unexpected error occurred')
    }
  
    setImporting(false)
  }

  return (
    <div className="p-4">
      <h1 className="text-xl font-bold mb-4">Warp Importer</h1>
      <button
        onClick={handleImport}
        disabled={importing}
        className="bg-blue-500 text-white px-4 py-2 rounded disabled:opacity-50"
      >
        {importing ? 'Importing...' : 'Start Import'}
      </button>
      <div className="mt-4">
        {importing && (
          <>
            <p>Page: {page}</p>
            <p>Records Imported: {count}</p>
            <p>Banner: {banner}</p>
          </>
        )}
        {error && <p className="text-red-500 mt-2">Error: {error}</p>}
      </div>
    </div>
  );
}

export default Import