package com.sonixa.innertube.pages

import com.sonixa.innertube.models.Album
import com.sonixa.innertube.models.AlbumItem
import com.sonixa.innertube.models.Artist
import com.sonixa.innertube.models.ArtistItem
import com.sonixa.innertube.models.MusicResponsiveListItemRenderer
import com.sonixa.innertube.models.MusicTwoRowItemRenderer
import com.sonixa.innertube.models.PlaylistItem
import com.sonixa.innertube.models.SongItem
import com.sonixa.innertube.models.YTItem
import com.sonixa.innertube.models.oddElements
import com.sonixa.innertube.utils.parseTime

data class LibraryAlbumsPage(
    val albums: List<AlbumItem>,
    val continuation: String?,
) {
    companion object {
        fun fromMusicTwoRowItemRenderer(renderer: MusicTwoRowItemRenderer): AlbumItem? {
            return AlbumItem(
                        browseId = renderer.navigationEndpoint.browseEndpoint?.browseId ?: return null,
                        playlistId = renderer.thumbnailOverlay?.musicItemThumbnailOverlayRenderer?.content
                            ?.musicPlayButtonRenderer?.playNavigationEndpoint
                            ?.watchPlaylistEndpoint?.playlistId ?: return null,
                        title = renderer.title.runs?.firstOrNull()?.text ?: return null,
                        artists = null,
                        year = renderer.subtitle?.runs?.lastOrNull()?.text?.toIntOrNull(),
                        thumbnail = renderer.thumbnailRenderer.musicThumbnailRenderer?.getThumbnailUrl() ?: return null,
                        explicit = renderer.subtitleBadges?.find {
                            it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
                        } != null
                    )
        }
    }
}
