import { Sidebar } from '../../components';
import { useState, useEffect } from 'react';

type Banner = {
  id: number
  name: string
  image: string
};

const WarpTracker = () => {
  const [banners, setBanners] = useState<Banner[]>([]);
  const [selected, setSelected] = useState(1001);

  useEffect(() => {
    const fetchBanners = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/v1/banners');
        const data = await response.json();

        const formatted = data.map((banner: { gachaId: number, bannerName: string; imgUrl: string }) => ({
          id: banner.gachaId,
          name: banner.bannerName,
          // image: "/Sidebar/" + banner.imgUrl,
          image: "/Sidebar/contract-zero.png",
        }));

        setBanners(formatted);
        if (formatted.length > 0) setSelected(formatted[0].gachaId)
      } catch (error) {
        console.error('Failed to fetch banners:', error)
      }
    };

    fetchBanners();
  }, [])

  return (
    <div className="flex min-h-screen flex-col items-center">
      {/* <Sidebar banners={banners} selectedBanner={selected} onSelect={setSelected} /> */}
      {/* <main className="flex-1 text-white p-6">

        {/* Main content */}
      {/* </main> */}
      <div className="w-full pt-10 text-white max-w-screen-xl px-3">
        <div className="flex items-center gap-4 mb-5">
          <h2 className="text-2xl text-gray-400">
            Warp Tracker
          </h2>
          <button className="bg-surface h-9 rounded-lg border border-gray-400 text-gray-400 px-3 hover:border-white hover:text-white font-medium cursor-pointer">
            Select Banner
          </button>
        </div>
        <div className="flex bg-[#1c2029b0] p-4 backdrop-blur-md rounded-xl border border-[#37383a]">
          {/* Left half (warp stats) */}
          <div className="w-[60%] px-4 mb-4">
            <div className="flex items-center my-2">
              <div className="flex-grow border-t border-[#37383a]"></div>
                <span className="mx-3 text-gray-400">Character Banner</span>
              <div className="flex-grow border-t border-[#37383a]"></div>
            </div>

            <div>
              <h2 className="text-2xl font-bold mb-4">
                {banners.find(b => b.id === selected)?.name || 'Loading...'}
              </h2>
              <div className="bg-[#181c24] rounded-md p-3 border border-[#37383a] grid grid-cols-2 md:grid-cols-3 gap-2 text-white">
                {/* Stat Items */}
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">5★ Pity</h3>
                  <p className="text-yellow-400 text-sm">16 / 90</p>
                </div>
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">4★ Pity</h3>
                  <p className="text-purple-400 text-sm">2 / 10</p>
                </div>
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">Total Warps</h3>
                  <p className="text-sm">429</p>
                </div>
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">Jade Spend</h3>
                  <p className="text-sm">68,640</p>
                </div>
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">Avg 5★</h3>
                  <p className="text-sm">52</p>
                </div>
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">Avg 4★</h3>
                  <p className="text-sm">7</p>
                </div>
                <div className="col-span-2 md:col-span-3">
                  <h3 className="text-sm font-semibold text-gray-300">50/50 Win Rate</h3>
                  <p className="text-sm">58.18%</p>
                </div>
              </div>
            </div>
          </div>
          {/* RIght half (image) */}
          <div>
            <div className="absolute bottom-0 right-[60px] h-[297px] w-[400px] bg-[#553b92] [transform:skewX(-10deg)]">
              <div style={{ writingMode: 'vertical-rl' }} className="relative text-left rotate-180 overflow-hidden text-clip max-h-[297px] break-words">
                <a style={{ fontFamily: '"Space Grotesk", sans-serif' }} className="uppercase font-bold font-space-grotesk text-7xl">Silver Wolf</a>
              </div>
            </div>
            <img
              src="/Banners/contract-zero.png"
              className="absolute w-120 -right-10 bottom-0 object-cover rounded-lg"
            />
          </div>
        </div>
      
        <h2 className="text-2xl text-gray-400 mb-5 mt-10">
          Warp Record
        </h2>
      </div>
    </div>
  )
}

export default WarpTracker