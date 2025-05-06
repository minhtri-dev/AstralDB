import { useEffect, useState } from 'react';
import { Banner } from '../../types/bannerType'

type Props = {
  selected: Banner | null;
  onSelect: (banner: Banner) => void;
  banners: Banner[];
  setBanners: (b: Banner[]) => void;
};

const BannerSelector = ({ selected, onSelect, banners, setBanners }: Props) => {
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    if (banners.length > 0) return;

    const fetchBanners = async () => {
      setLoading(true);
      try {
        const response = await fetch('http://localhost:8080/api/v1/banners');
        const data = await response.json();

        const formatted = data.map((banner: { gachaId: number; bannerName: string; imgUrl: string, itemId: number }) => ({
          gacha_id: banner.gachaId,
          banner_name: banner.bannerName,
          image_url: banner.imgUrl, // or use banner.imgUrl
          item_id: banner.itemId
        }));

        setBanners(formatted);
      } catch (e) {
        console.error('Failed to load banners', e);
      } finally {
        setLoading(false);
      }
    };

    fetchBanners();
  }, [banners, setBanners]);

  return (
    <div>
      <h1 className="text-xl font-bold mb-4">Select a Banner</h1>
      {loading && <p className="text-gray-400">Loading banners...</p>}
      <ul className="space-y-2">
        {banners.map((banner) => (
          <li
            key={banner.gacha_id}
            className={`bg-[#181B22] flex items-center cursor-pointer transition hover:bg-gray-800 overflow-hidden rounded-lg border border-gray-600 ${
              selected?.gacha_id === banner.gacha_id ? 'bg-gray-800 font-semibold' : ''
            }`}
            onClick={() => onSelect(banner)}
          >
            <img src={banner.image_url} alt={banner.banner_name} className="w-20 h-12 object-cover mr-3" />
            <span className="ml-auto text-white pr-2">{banner.banner_name}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BannerSelector;
