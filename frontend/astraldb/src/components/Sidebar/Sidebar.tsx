const Sidebar = ({ banners, selectedBanner, onSelect }: {
    banners: { name: string; image: string }[];
  selectedBanner: string;
  onSelect: (banner: string) => void;
}) => {
  return (
    <aside className="bg-[#1E1E1E] text-white w-100 h-full flex flex-col">
      <h1 className="text-xl font-bold p-3 tracking-wide mb-2">Character Banner</h1>
      <ul className="space-y-2">
      {banners.map((banner) => (
          <li
            key={banner.name}
            className={`flex items-center cursor-pointer transition hover:bg-gray-800 ${
              selectedBanner === banner.name ? 'bg-gray-800 font-semibold' : ''
            }`}
            onClick={() => onSelect(banner.name)}
          >
            <img
              src={banner.image}
              alt={banner.name}
              className="w-50 h-12 object-cover mr-3"
            />
             <span className="ml-auto text-white pr-2">{banner.name}</span>
          </li>
        ))}
      </ul>
    </aside>
  );
};

export default Sidebar;
