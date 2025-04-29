  import { fetchWarpData } from '../../services/astraldbApi'

const Import = () => {

  const handleClick = () => {
    console.log("hi")
    fetchWarpData("http://public-operation-hkrpg-sg.hoyoverse.com/common/gacha_record/api/getGachaLog?authkey_ver=1&sign_type=2&lang=en&authkey=Ji06TN0jxGmj6gWwtrf7t5mdt8UiW5Ee7AHAOskCxIc8vcCezR9YuOQLEpCO316LkpDkoG5ndeyF5NBHHyBctouL%2bgIJhozL35eM2gPbFKDmAdiwoqjsNfPMBfX4%2fd9SPMxBuRcmFT1WzV%2bbGGN9VlCcOB1pXl55NkWGG5SEuZFEGi9i7G%2fuKoNfo2D6SqmUtGIm6d5wtOxrqawJbt8UQcTIsJVrxtBRziUrhD%2fLQZ3zcO8fOe77xz58XBtzH3ndhIzgheRBnSJEBFPweonLsEl%2fd0JUyCmF81t8BvMOGIG2tzdMsA%2b4Kx1%2fSStAIfPv6U1cQpO%2f5WAOmtt00QTkMmLLE3JXWU%2bJtBkdFXf%2fTDHlfGeOPU7Uu8s%2fwQd8PlsUGH0zY2hqhuozgJtw1sKyCYZIMCx8TIWM8njuPRfpCBuffV3zemPGxclX8SR68WA4VLST3VP4ekiOqTcm5jk8P3H5dcPZiMsLGmm4mw1FKXB2IMmfnK18t6ewwLKE6FxE4hHsZjgFzU6b5OE1cdC4vNDgxu2zBUoioBMVUcUbJ%2bAEW3bdI7nnppv6Le1ehTMLzY4JE4MtR9kV1aqqCtCIzF7W6Tj2bTTe9G%2fRfeXKHgLMPSH7JIn2T1AWJSOTF7yD7OVuS9SOyD8k8iUZ3XnZkPAHxu6PexmpfTwr6zDU9cs%3d&game_biz=hkrpg_global")
  }
  
  
  return (
    <>
    <button onClick={handleClick}>CLICK ME</button>
    <div>Import</div>
    </>
  )
}

export default Import