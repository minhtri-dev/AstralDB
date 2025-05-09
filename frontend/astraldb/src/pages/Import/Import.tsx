import { useState } from 'react'
import { fetchWarpData } from '@services/astraldb'

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
  
    const testUrl = 'https://public-operation-hkrpg-sg.hoyoverse.com/common/gacha_record/api/getGachaLog?authkey_ver=1&sign_type=2&lang=en&authkey=Ji06TN0jxGmj6gWwtrf7t5mdt8UiW5Ee7AHAOskCxIc8vcCezR9YuOQLEpCO316LkpDkoG5ndeyF5NBHHyBctouL%2bgIJhozL35eM2gPbFKDmAdiwoqjsNfPMBfX4%2fd9SPMxBuRcmFT1WzV%2bbGGN9VlCcOB1pXl55NkWGG5SEuZFEGi9i7G%2fuKoNfo2D6SqmUtGIm6d5wtOxrqawJbt8UQcTIsJVrxtBRziUrhD%2fLQZ3zcO8fOe77xz58XBtzH3ndhIzgheRBnSJEBFPweonLsEl%2fd0JUyCmF81t8BvMOGIG2tzdMsA%2b4Kx1%2fSStAIfPv6U1cQpO%2f5WAOmtt00QTkMp3X%2foD2WWnO%2fiLerRQmRA5YbfFJodyl6DgobBQvvl0sMnZAsj%2f%2fwZvqWONUK%2f9FuKVIEQ%2fsUkE%2fNpzr8D554OYhn4vVsuO06zKPyHDwRJEsjSmsOfNJqapLiCPA%2ftmchJpc75ivAd%2bEJm0t4fREiIhha0tIf2BQ%2ff9ZelZQZH4c%2fcETAWJxJRq1wYesIwRTwtWxRzoegHBQ3%2bld1gIhdM376fYfSK4fUW695WjZOxsOq5VGaM4sVdI3ATUEQLi3Kjiicv5yfwwZZVBcwbGplkrYLBEgoA7%2bqlkaM%2f9srlqNi8%2fRtEguxS9Dtvz3sa7%2ffD9dQJQ6yCsfeNGZhubxNsc%3d&game_biz=hkrpg_global'
  
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
      setError('Unexpected error occurred:' + err)
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
  )
}

export default Import