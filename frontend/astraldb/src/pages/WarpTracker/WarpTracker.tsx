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
        <h2 className="text-2xl text-gray-400 mb-4">
          Warp Tracker
        </h2>
        <div className="flex flex-col md:flex-row bg-[#1c2029b0] backdrop-blur-md rounded-xl p-6 mx-auto border border-[#37383a]">
          <div className="flex-shrink-0 mb-4 md:mb-0 md:mr-6">
            <div
              className="absolute bg-[#553b92]"
              style={{
                bottom: 0,
                left: '150px',
                height: '506px',
                width: '400px',
                transform: 'skewX(-10deg)',
                WebkitTransform: 'skewX(-10deg)',
              }}
            ></div>
            <img
              src="/Banners/contract-zero.png"
              alt="Character"
              className="relative w-140 h-110 object-cover rounded-lg"
            />
          </div>
          
          
          <div className='w-full px-4 md:px-8'>
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
                  <p className='text-sm'>429</p>
                </div>
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">Jade Spend</h3>
                  <p className='text-sm'>68,640</p>
                </div>
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">Avg 5★</h3>
                  <p className='text-sm'>52</p>
                </div>
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">Avg 4★</h3>
                  <p className='text-sm'>7</p>
                </div>
                <div className="col-span-2 md:col-span-3">
                  <h3 className="text-sm font-semibold text-gray-300">50/50 Win Rate</h3>
                  <p className='text-sm'>58.18%</p>
                </div>
              </div>
            </div>

            {/* Divider and spacing */}
            <div className="flex items-center my-4">
              <div className="flex-grow border-t border-[#37383a]"></div>
                <span className="mx-3 text-gray-400">Light Cone Banner</span>
              <div className="flex-grow border-t border-[#37383a]"></div>
            </div>

            <div>
              <h2 className="text-2xl font-bold mb-4">Incessant Rain</h2>
              <div className="bg-[#181c24] rounded-md p-3 border border-[#37383a] grid grid-cols-2 md:grid-cols-3 gap-1 text-white">
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
                  <p className='text-sm'>429</p>
                </div>
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">Jade Spend</h3>
                  <p className='text-sm'>68,640</p>
                </div>
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">Avg 5★</h3>
                  <p className='text-sm'>52</p>
                </div>
                <div>
                  <h3 className="text-sm font-semibold text-gray-300">Avg 4★</h3>
                  <p className='text-sm'>7</p>
                </div>
                <div className="col-span-2 md:col-span-3">
                  <h3 className="text-sm font-semibold text-gray-300">50/50 Win Rate</h3>
                  <p className='text-sm'>58.18%</p>
                </div>
              </div>
            </div>
          </div>
        </div>

        <h2 className="text-2xl text-gray-400 mb-4">
          Warp List
        </h2>

      </div>
    </div>
  )
}

export default WarpTracker